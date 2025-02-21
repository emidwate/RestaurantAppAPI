package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    private final CustomerOrderService orderService;

    public CustomerOrderController(CustomerOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orderList")
    public List<CustomerOrderDTO> getOrder() {
        return orderService.getOrder();
    }

    @PostMapping("/orderItem")
    public void addItemToOrder(@Valid @RequestBody CustomerOrderDTO orderDTO) {
        orderService.addItemToOrder(orderDTO);
    }

    @DeleteMapping("/orderItem/{id}")
    public void deleteItemFromOrder(@PathVariable("id") Long id) {
        orderService.deleteItemFromOrder(id);
    }

    @DeleteMapping("/order/truncate")
    public void truncateOrderTable() {
        orderService.truncateOrderTable();
    }
}
