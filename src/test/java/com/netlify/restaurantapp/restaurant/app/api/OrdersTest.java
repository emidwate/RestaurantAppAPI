package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersTest {
    private Orders order;

    @BeforeEach
    void setUp() {
        order = new Orders();
    }

    @Test
    void testOrdersId() {
        order.setOrdersId(2L);
        assertEquals(2L, order.getOrdersId());
    }

    @Test
    void testOrdersStatus() {
        order.setStatus(Orders.Status.PENDING);
        assertEquals(Orders.Status.PENDING, order.getStatus());
    }

}
