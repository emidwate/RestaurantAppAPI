package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FoodDTO {
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Ingredients cannot be null")
    @NotBlank(message = "Ingredients cannot be blank")
    private String ingredients;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Emoji cannot be null")
    @NotBlank(message = "Emoji cannot be blank")
    private String emoji;
}
