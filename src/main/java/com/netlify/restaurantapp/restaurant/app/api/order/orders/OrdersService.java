package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deleteSavedOrderById(Long id) {
        Orders order = entityManager.find(Orders.class, id);
        if (order != null) {
            List<CustomerSavedOrder> savedOrdersList = order.getCustomerSavedOrderList();
            for (CustomerSavedOrder savedOrder : savedOrdersList) {
                entityManager.remove(savedOrder);
            }
            entityManager.remove(order);
        } else {
            throw new IllegalArgumentException("No order with provided ID found!");
        }
    }
}
