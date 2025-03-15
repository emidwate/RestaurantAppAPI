package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_order_id")
    private Long customerOrderId;

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
}
