package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodDTO;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodMapperTest {

    private Food food;

    @BeforeEach
    void setUp() {
        food = new Food();
    }

    @Test
    void testFoodMapper() {
        food.setName("Bigos");
        food.setEmoji("\uD83C\uDF72");
        food.setPrice(14.0);
        food.setIngredients("kapusta świeża, kapusta kiszona, boczek");

        FoodDTO foodDTO = FoodMapper.INSTANCE.toDTO(food);

        assertThat(foodDTO).isNotNull();
        assertThat(foodDTO.getEmoji()).isEqualTo("\uD83C\uDF72");
        assertThat(foodDTO.getIngredients()).isEqualTo("kapusta świeża, kapusta kiszona, boczek");
        assertThat(foodDTO.getName()).isEqualTo("Bigos");
        assertThat(foodDTO.getPrice()).isEqualTo(14.0);
    }

}
