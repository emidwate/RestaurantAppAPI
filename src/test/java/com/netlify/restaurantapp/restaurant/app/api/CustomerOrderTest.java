package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerOrderTest {
    private CustomerOrder customerOrder;

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder();
    }

    @Test
    void testName() {
        customerOrder.setName("Bigos");
        assertEquals("Bigos", customerOrder.getName());
    }

    @Test
    void testPrice() {
        customerOrder.setPrice(12.0);
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
