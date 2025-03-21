package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import generated.api.OrdersApi;
import generated.api.SaveOrdersApi;
import generated.models.OrdersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrdersController implements OrdersApi, SaveOrdersApi {

    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    private final OrdersService ordersService;
    private final OrdersMapper ordersMapper;

    public OrdersController(OrdersService ordersService,
                            OrdersMapper ordersMapper) {
        this.ordersService = ordersService;
        this.ordersMapper = ordersMapper;
    }

    public ResponseEntity<Void> deleteSavedOrderById(Long ordersId) {
        ordersService.deleteSavedOrderById(ordersId);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> saveOrders(OrdersDTO ordersDTO) {
        ordersService.saveOrders(ordersMapper.toEntity(ordersDTO));
        return ResponseEntity.ok().build();
    }
}
