package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "saved_order")
public class CustomerSavedOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saved_order_id")
    private Long savedOrderId;

    @Valid

    @Column(name = "food_id")
    private Long foodId;

    @Min(value = 0, message = "Price cannot be negative")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "order_id")
    // Without JsonBackReference on child when we fetch data it creates an infinite loop
    @JsonBackReference
    private Orders order;

    public CustomerSavedOrder() {}

    public CustomerSavedOrder (
            Long order_id,
            Long food_id,
            Double price,
            String name
    ) {
        this.foodId = food_id;
        this.price = price;
        this.name = name;
    }

    public Long getSavedOrderId() {
        return savedOrderId;
    }

    public void setSavedOrderId(Long savedOrderId) {
        this.savedOrderId = savedOrderId;
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

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String toString() {
        return "CustomerSavedOrder{" +
                "savedOrderId=" + savedOrderId +
                ", foodId=" + foodId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", order=" + (order != null ? order.getOrdersId() : "null") +
                '}';
    }

}
