package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_order_id")
    private Long customerOrderId;

    @Valid

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    @Column(name = "price")
    private Double price;

    @Column(name = "food_id")
    private Long foodId;

    public CustomerOrder() {}

    public CustomerOrder(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long food_id) {
        this.foodId = food_id;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
