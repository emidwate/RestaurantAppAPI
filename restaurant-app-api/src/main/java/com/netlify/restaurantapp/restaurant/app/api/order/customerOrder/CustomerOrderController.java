package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import generated.api.OrderApi;
import generated.api.OrderItemApi;
import generated.api.OrderListApi;
import generated.models.CustomerOrderDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerOrderController implements OrderListApi, OrderItemApi, OrderApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    private final CustomerOrderService orderService;
    private final CustomerOrderMapper customerOrderMapper;

    public CustomerOrderController(CustomerOrderService orderService,
                                   CustomerOrderMapper customerOrderMapper) {
        this.orderService = orderService;
        this.customerOrderMapper = customerOrderMapper;
    }

    public ResponseEntity<List<CustomerOrderDTO>> getOrder() {
        List<CustomerOrderDTO> customerOrderList = orderService.getOrder()
                .stream()
                .map(customerOrderMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerOrderList);
    }

    public ResponseEntity<Void> addItemToOrder(CustomerOrderDTO customerOrderDTO) {
        orderService.addItemToOrder(customerOrderMapper.toEntity(customerOrderDTO));
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Void> deleteItemFromOrder(Long id) {
        orderService.deleteItemFromOrder(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> truncateOrderTable() {
        orderService.truncateOrderTable();
        return  ResponseEntity.ok().build();
    }
}
