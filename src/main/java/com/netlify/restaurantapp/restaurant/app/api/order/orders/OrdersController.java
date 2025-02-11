package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @DeleteMapping("/order/{ordersId}")
    public void deleteSavedOrderById(@PathVariable("ordersId") Long id) {
        ordersService.deleteSavedOrderById(id);
    }
}
