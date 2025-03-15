package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "food_items")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Valid

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Ingredients cannot be null")
    @NotBlank(message = "Ingredients cannot be blank")
    @Column(name = "ingredients")
    private String ingredients;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Emoji cannot be null")
    @NotBlank(message = "Emoji cannot be blank")
    @Column(name = "emoji")
    private String emoji;
}
