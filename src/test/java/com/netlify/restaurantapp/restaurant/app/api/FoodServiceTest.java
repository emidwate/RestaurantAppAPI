package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {

    private FoodDTO foodDTO;

    @Mock
    private FoodMapper foodMapper;

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    @BeforeEach
    void setUp() {
        foodDTO = new FoodDTO();
    }

    @Test
    void shouldAddNewFood() {
        foodDTO.setName("Bigos");
        foodDTO.setIngredients("kapusta świeża, kapusta kiszona, boczek");
        foodDTO.setPrice(10.0);
        foodDTO.setEmoji("\uD83C\uDF72");
        foodService.addNewFood(foodDTO);
        verify(foodRepository, times(1)).save(foodMapper.toEntity(foodDTO));
    }
}
