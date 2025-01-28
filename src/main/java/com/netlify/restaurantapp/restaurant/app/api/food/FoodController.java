package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/getFoodList")
    public List<Food> getFoodList() {
        return foodService.getAllFood();
    }

    @GetMapping("/food/{id}")
    public Food getFoodById(@PathVariable("id") Long id) {
        return foodService.getFoodById(id);
    }

    @PostMapping("/addNewFood")
    public void registerNewFood(@Valid @RequestBody Food food) {
        foodService.addNewFood(food);
    }

    @DeleteMapping("/food/{id}")
    public void deleteFoodById(@PathVariable("id") Long id) {
        foodService.deleteFoodById(id);
    }

}