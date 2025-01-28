package com.netlify.restaurantapp.restaurant.app.api;

import org.junit.jupiter.api.Test;
import jakarta.xml.bind.ValidationException;
import org.springframework.boot.test.context.SpringBootTest;
import com.netlify.restaurantapp.restaurant.app.api.food.Food;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void testFoodName() {
        var food = new Food();
        food.setName("Bigos");
        assertEquals("Bigos", food.getName());
    }

    @Test
    void testFoodIngredients() {
        var food = new Food();
        food.setIngredients("kapusta świeża, kapusta kiszona, boczek");
        assertEquals("kapusta świeża, kapusta kiszona, boczek", food.getIngredients());
    }

    @Test
    void testFoodPrice() {
        var food = new Food();
        food.setPrice(10.0);
        assertEquals(10.0, food.getPrice());
    }

    @Test
    void testFoodEmoji() {
        var food = new Food();
        food.setEmoji("\uD83C\uDF72");
        assertEquals("\uD83C\uDF72", food.getEmoji());
    }
}
