package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerSavedOrderDTO {
    private Long savedOrderId;
    private Long foodId;

    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    private Orders order;
}
