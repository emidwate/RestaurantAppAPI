package com.netlify.restaurantapp.restaurant.app.api.food;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import generated.models.FoodDTO;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    @Mapping(source = "id", target = "foodId")
    Food toEntity(FoodDTO foodDTO);
    @Mapping(source = "foodId", target = "id")
    FoodDTO toDTO(Food food);
}
