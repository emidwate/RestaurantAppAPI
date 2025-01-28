package com.netlify.restaurantapp.restaurant.app.api.food;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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

    public Food() {}

    public Food(String name,
                String ingredients,
                Double price,
                String emoji
    ) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.emoji = emoji;
    }

    public Long getFoodId() {
        return foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
