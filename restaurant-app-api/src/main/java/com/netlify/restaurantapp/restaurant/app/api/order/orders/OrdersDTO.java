package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import lombok.Data;

import java.util.List;

@Data
public class OrdersDTO {

    private Long ordersId;
    private Status status;

    private List<CustomerSavedOrder> customerSavedOrderList;

    public enum Status {
        ORDERED,
        PENDING,
        COMPLETED
    }
}
