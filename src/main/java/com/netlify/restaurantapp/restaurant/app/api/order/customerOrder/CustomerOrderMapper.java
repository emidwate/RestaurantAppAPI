package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

    CustomerOrder toEntity(CustomerOrderDTO customerOrderDTO);
    CustomerOrderDTO toDTO(CustomerOrder customerOrder);
}
