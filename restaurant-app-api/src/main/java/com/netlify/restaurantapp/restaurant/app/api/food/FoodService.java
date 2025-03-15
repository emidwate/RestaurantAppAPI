package com.netlify.restaurantapp.restaurant.app.api.food;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository,
                       FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoodList() {
        List<Food> foodList = foodRepository.findAll();
        return new ArrayList<>(foodList);
    }

    public void addNewFood(Food food) {
        foodRepository.save(food);
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food with ID " + id + " not found"));
    }

    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }
}