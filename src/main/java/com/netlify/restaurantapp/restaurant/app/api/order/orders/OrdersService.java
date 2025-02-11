package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void deleteSavedOrderById(Long id) {
        ordersRepository.deleteSavedOrderById(id);
    }
}
