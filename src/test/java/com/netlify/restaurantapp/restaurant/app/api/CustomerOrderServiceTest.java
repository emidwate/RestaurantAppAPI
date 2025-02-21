package com.netlify.restaurantapp.restaurant.app.api;


import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrder;
import com.netlify.restaurantapp.restaurant.app.api.order.customerOrder.CustomerOrderRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerOrderServiceTest {
    
    private CustomerOrder customerOrder;
    private Food food;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder();
        food = new Food();
    }

    @Test
    void testSaveCustomerOrder() {
        food.setPrice(14.0);
        food.setName("Pizza");
        food.setEmoji("\uD83C\uDF55");
        food.setIngredients("pepperoni, mushrooms, mozzarella");

        customerOrder.setFoodId(food.getFoodId());
        customerOrder.setPrice(food.getPrice());
        customerOrder.setName(food.getName());

        customerOrderRepository.save(customerOrder);

        assertThat(customerOrderRepository.findById(customerOrder.getCustomerOrderId())).isPresent();

    }
}
