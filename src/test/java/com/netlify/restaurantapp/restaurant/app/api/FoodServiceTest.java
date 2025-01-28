package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodRepository;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {

    private Food food;

    @Mock
    FoodRepository foodRepository;

    @InjectMocks
    FoodService foodService;

    @BeforeEach
    void setUp() {
        food = new Food();
    }

    @Test
    void shouldAddNewFood() {
        food.setName("Bigos");
        food.setIngredients("kapusta świeża, kapusta kiszona, boczek");
        food.setPrice(10.0);
        food.setEmoji("\uD83C\uDF72");
        foodService.addNewFood(food);
        verify(foodRepository, times(1)).save(food);
    }
}
