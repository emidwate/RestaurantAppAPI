package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerSavedOrderTest {
    private CustomerSavedOrder customerSavedOrder;

    @BeforeEach
    void setUp() {
        customerSavedOrder = new CustomerSavedOrder();
    }

    @Test
    void testCustomerSavedOrderId() {
        customerSavedOrder.setSavedOrderId(2L);
        assertEquals(2L, customerSavedOrder.getSavedOrderId());
    }

    @Test
    void testCustomerSavedOrderFoodId() {
        customerSavedOrder.setFoodId(3L);
        assertEquals(3L, customerSavedOrder.getFoodId());
    }

    @Test
    void testCustomerSavedOrderPrice() {
        customerSavedOrder.setPrice(12.3);
        assertEquals(12.3, customerSavedOrder.getPrice());
    }

    @Test
    void testCustomerSavedOrderName() {
        customerSavedOrder.setName("Kapusniak");
        assertEquals("Kapusniak", customerSavedOrder.getName());
    }

    @Test
    void testCustomerSavedOrdersId() {
        Orders order = new Orders();

        order.setOrdersId(2L);
        order.setStatus(Orders.Status.COMPLETED);

        customerSavedOrder.setOrder(order);

        assertEquals(2L, order.getOrdersId());
        assertEquals(Orders.Status.COMPLETED, order.getStatus());
    }
}
