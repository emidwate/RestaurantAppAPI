package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrder;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrderMapper;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrderRepository;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrderService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerOrderServiceTest {
    
    private Food food;
    private CustomerOrder customerOrder;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerOrderService customerOrderService;

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder();
        food = new Food();
    }

    @Test
    void testAddItemToOrder() {
        food.setPrice(14.0);
        food.setName("Pizza");
        food.setFoodId(1L);

        customerOrder.setPrice(food.getPrice());
        customerOrder.setName(food.getName());
        customerOrder.setFoodId(food.getFoodId());

        customerOrderService.addItemToOrder(customerOrder);

        customerOrderRepository.save(customerOrder);

        assertThat(customerOrderRepository.findById(customerOrder.getCustomerOrderId())).isPresent();

    }
}
