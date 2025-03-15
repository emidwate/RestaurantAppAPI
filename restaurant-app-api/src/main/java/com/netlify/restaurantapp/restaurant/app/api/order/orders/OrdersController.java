package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrdersController {
    private final OrdersService ordersService;
    private final OrdersMapper ordersMapper;

    public OrdersController(OrdersService ordersService,
                            OrdersMapper ordersMapper) {
        this.ordersService = ordersService;
        this.ordersMapper = ordersMapper;
    }

    @DeleteMapping("/order/{ordersId}")
    public void deleteSavedOrderById(@PathVariable("ordersId") Long id) {
        ordersService.deleteSavedOrderById(id);
    }

    @PostMapping("/saveOrders")
    public void saveOrders(@Valid @RequestBody OrdersDTO ordersDTO) {
        ordersService.saveOrders(ordersMapper.toEntity(ordersDTO));
    }
}
