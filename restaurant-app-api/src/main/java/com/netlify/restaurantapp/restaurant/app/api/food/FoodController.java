package com.netlify.restaurantapp.restaurant.app.api.food;

import generated.api.FoodApi;
import generated.api.FoodListApi;
import generated.models.FoodDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FoodController implements FoodApi, FoodListApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    private final FoodService foodService;
    private final FoodMapper foodMapper;

    public FoodController(FoodService foodService,
                          FoodMapper foodMapper) {
        this.foodService = foodService;
        this.foodMapper = foodMapper;
    }

    public ResponseEntity<Void> addNewFood(FoodDTO foodDTO) {
        foodService.addNewFood(foodMapper.toEntity(foodDTO));
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Void> deleteFoodById(Long id) {
        foodService.deleteFoodById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<FoodDTO>> getFoodById(Long id) {
        FoodDTO foodDTO = foodMapper.toDTO(foodService.getFoodById(id));
        return ResponseEntity.ok(List.of(foodDTO));
    }

    public ResponseEntity<List<FoodDTO>> getFoodList() {
        List<FoodDTO> foodList = foodService.getFoodList()
                .stream()
                .map(foodMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(foodList);
    }
}