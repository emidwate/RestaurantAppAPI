package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foodList")
    public List<FoodDTO> getFoodList() {
        return foodService.getFoodList();
    }

    @GetMapping("/food/{id}")
    public FoodDTO getFoodById(@PathVariable("id") Long id) {
        return foodService.getFoodById(id);
    }

    @DeleteMapping("/food/{id}")
    public void deleteFoodById(@PathVariable("id") Long id) {
        foodService.deleteFoodById(id);
    }

    @PostMapping("/food")
    public void addNewFood(@Valid @RequestBody FoodDTO foodDTO) {
        foodService.addNewFood(foodDTO);
    }
}