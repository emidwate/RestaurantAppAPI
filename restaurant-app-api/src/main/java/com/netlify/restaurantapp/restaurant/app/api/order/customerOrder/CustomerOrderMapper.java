package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import org.mapstruct.Mapper;
import generated.models.CustomerOrderDTO;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {
    CustomerOrder toEntity(CustomerOrderDTO customerOrderDTO);
    CustomerOrderDTO toDTO(CustomerOrder customerOrder);
}
