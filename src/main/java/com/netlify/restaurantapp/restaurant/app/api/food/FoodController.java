package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foodList")
    public List<Food> getFoodList() {
        return foodService.getFoodList();
    }

    @GetMapping("/food/{id}")
    public Food getFoodById(@PathVariable("id") Long id) {
        return foodService.getFoodById(id);
    }

    @DeleteMapping("/food/{id}")
    public void deleteFoodById(@PathVariable("id") Long id) {
        foodService.deleteFoodById(id);
    }

    @PostMapping("/food")
    public void addNewFood(@Valid @RequestBody Food food) {
        foodService.addNewFood(food);
    }


}