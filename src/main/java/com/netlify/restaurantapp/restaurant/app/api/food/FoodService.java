package com.netlify.restaurantapp.restaurant.app.api.food;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
@ComponentScan(basePackages = {"com.netlify.restaurantapp.restaurant.app.api.food"})
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository,
                       FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public List<FoodDTO> getFoodList() {
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream()
                .map(foodMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void addNewFood(FoodDTO foodDTO) {
        Food food = foodMapper.toEntity(foodDTO);
        foodRepository.save(food);
    }

    public FoodDTO getFoodById(Long id) {
        return foodRepository.findById(id)
                .map(foodMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Food with ID " + id + " not found"));
    }

    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }
}