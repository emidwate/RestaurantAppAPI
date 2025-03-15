package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long ordersId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Setter
    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")

    // Using JsonManagedReference on the parent to prevent infinite loop during fetch
    @JsonManagedReference
    private List<CustomerSavedOrder> customerSavedOrderList;

    public enum Status {
        ORDERED,
        PENDING,
        COMPLETED
    }
}
