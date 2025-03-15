package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerSavedOrderMapper {
    CustomerSavedOrder toEntity(CustomerSavedOrderDTO customerSavedOrderDTO);
    CustomerSavedOrderDTO toDTO(CustomerSavedOrder customerSavedOrder);
}
