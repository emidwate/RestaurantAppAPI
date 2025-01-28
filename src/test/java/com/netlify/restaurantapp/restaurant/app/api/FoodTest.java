package com.netlify.restaurantapp.restaurant.app.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.netlify.restaurantapp.restaurant.app.api.food.Food;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    private Food food;

    @BeforeEach
    void setUp() {
        food = new Food();
    }

    @Test
    void testFoodName() {
        food.setName("Bigos");
        assertEquals("Bigos", food.getName());
    }

    @Test
    void testFoodIngredients() {
        food.setIngredients("kapusta świeża, kapusta kiszona, boczek");
        assertEquals("kapusta świeża, kapusta kiszona, boczek", food.getIngredients());
    }

    @Test
    void testFoodPrice() {
        food.setPrice(10.0);
        assertEquals(10.0, food.getPrice());
    }

    @Test
    void testFoodEmoji() {
        food.setEmoji("\uD83C\uDF72");
        assertEquals("\uD83C\uDF72", food.getEmoji());
    }
}
