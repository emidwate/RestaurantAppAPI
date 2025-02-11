package com.netlify.restaurantapp.restaurant.app.api.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoodList() {
        return foodRepository.findAll();
    }

    public void addNewFood(Food food) {
        foodRepository.save(food);
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Food with ID " + id + " not found"));
    }

    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }
}