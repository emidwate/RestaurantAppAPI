package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "saved_order")
public class CustomerSavedOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saved_order_id")
    private Long savedOrderId;

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

    // Using @JsonBackReference on the child to prevent infinite loop during data fetch
    @JsonBackReference
    private Orders order;

}
