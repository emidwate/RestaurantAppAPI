package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "saved_order")
public class CustomerSavedOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saved_order_id")
    private Long savedOrderId;

    @Valid

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "food_id")
    private Long foodId;

    @Min(value = 0, message = "Price cannot be negative")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    public CustomerSavedOrder() {}

    public CustomerSavedOrder (
            Long order_id,
            Long food_id,
            Double price,
            String name
    ) {
        this.orderId = order_id;
        this.foodId = food_id;
        this.price = price;
        this.name = name;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    public Long getOderId() {
        return orderId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long food_id) {
        this.foodId = food_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
