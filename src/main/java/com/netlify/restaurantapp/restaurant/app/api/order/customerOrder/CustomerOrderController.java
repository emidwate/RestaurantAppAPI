package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CustomerOrder> getOrder() {
        return orderService.getOrder();
    }

    @PostMapping("/addNewOrderItem")
    public void registerNewOrder(@Valid @RequestBody CustomerOrder order) {
        orderService.addItemToOrder(order);
    }

    @DeleteMapping("/removeOrderItem/{id}")
    public void deleteOrderItem(@PathVariable("id") Long id) {
        orderService.deleteOrderItemById(id);
    }

    @DeleteMapping("/order/truncate")
    public void truncateOrderTable() {
        orderService.truncateOrderTable();
    }
}
