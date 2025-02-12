package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<CustomerSavedOrder> customerSavedOrderList;

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

    public List<CustomerSavedOrder> getCustomerSavedOrderList() {
        return customerSavedOrderList;
    }

    public void setCustomerSavedOrderList(List<CustomerSavedOrder> customerSavedOrderList) {
        this.customerSavedOrderList = customerSavedOrderList;
    }
}
