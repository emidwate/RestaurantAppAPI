package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerOrderTest {
    private CustomerOrder customerOrder;

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder("Bigos", 12.0);
    }

    @Test
    void testName() {
        assertEquals("Bigos", customerOrder.getName());
    }

    @Test
    void testPrice() {
        assertEquals(12.0, customerOrder.getPrice());
    }

    @Test
    void testFoodId() {
        customerOrder.setFoodId(4L);
        assertEquals(4L, customerOrder.getFoodId());
    }

    @Test
    void testCustomerOrderId() {
        customerOrder.setCustomerOrderId(2L);
        assertEquals(2L, customerOrder.getCustomerOrderId());
    }
}
