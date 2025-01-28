package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Orders() {}

    public Orders(Status status) {
        this.status = status;
    }

    public void setOrdersId(Long orders_id) {
        this.ordersId = orders_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public enum Status {
        ORDERED,
        PENDING,
        COMPLETED
    }

}
