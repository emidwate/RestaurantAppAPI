package com.netlify.restaurantapp.restaurant.app.api.food;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper( FoodMapper.class );

    @Mapping(source = "id", target = "foodId")
    Food toEntity(FoodDTO foodDTO);
    @Mapping(source = "foodId", target = "id")
    FoodDTO toDTO(Food food);
}
