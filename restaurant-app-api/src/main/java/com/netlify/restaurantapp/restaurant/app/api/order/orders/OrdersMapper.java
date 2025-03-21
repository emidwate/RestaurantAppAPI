package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import generated.models.OrdersDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Orders toEntity(OrdersDTO ordersDTO);
    OrdersDTO toDTO(Orders orders);
}
