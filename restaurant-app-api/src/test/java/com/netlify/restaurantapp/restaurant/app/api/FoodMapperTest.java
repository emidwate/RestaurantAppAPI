package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import generated.models.FoodDTO;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FoodMapperTest {

    private Food food;

    @Autowired
    private FoodMapper foodMapper;

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

        FoodDTO foodDTO = foodMapper.toDTO(food);

        assertThat(foodDTO).isNotNull();
        assertThat(foodDTO.getEmoji()).isEqualTo("\uD83C\uDF72");
        assertThat(foodDTO.getIngredients()).isEqualTo("kapusta świeża, kapusta kiszona, boczek");
        assertThat(foodDTO.getName()).isEqualTo("Bigos");
        assertThat(foodDTO.getPrice()).isEqualTo(BigDecimal.valueOf(14.0));
    }

}
