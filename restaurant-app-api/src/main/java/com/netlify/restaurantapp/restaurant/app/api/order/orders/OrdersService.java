package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import com.netlify.restaurantapp.restaurant.app.api.food.FoodMapper;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void saveOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    @Transactional
    public void deleteSavedOrderById(Long id) {
        Orders order = entityManager.find(Orders.class, id);
        if (order != null) {
            entityManager.remove(order);
        } else {
            throw new IllegalArgumentException("No order with provided ID found!");
        }
    }
}
