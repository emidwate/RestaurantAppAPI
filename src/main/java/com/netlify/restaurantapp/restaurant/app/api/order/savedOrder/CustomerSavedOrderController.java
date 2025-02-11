package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerSavedOrderController {
    private final CustomerSavedOrderService savedOrderService;

    public CustomerSavedOrderController(CustomerSavedOrderService savedOrderService) {
        this.savedOrderService = savedOrderService;
    }

    @PostMapping("/order")
    public void saveOrder(@Valid @RequestBody List<CustomerSavedOrder> savedOrderList,
                          @RequestParam String status) {
        savedOrderService.saveOrder(savedOrderList, status);
    }

    @DeleteMapping("/order/{orderId}/food/{foodId}")
    public void deleteFoodItemFromSavedOrderById(@PathVariable("orderId") Long orderId,
                                                 @PathVariable("foodId") Long foodId) {
        savedOrderService.deleteFoodItemFromSavedOrderById(orderId, foodId);
    }

    @PutMapping("/order/{orderId}/food/{foodId}")
    public void addFoodItemToSavedOrderById(@PathVariable("orderId") Long orderId,
                                            @PathVariable("foodId") Long foodId) {
        savedOrderService.addFoodItemToSavedOrderById(orderId, foodId);
    }

    @GetMapping("/order/{orderId}")
    public List<CustomerSavedOrder> getSavedOrderById(@PathVariable("orderId") Long orderId) {
        return savedOrderService.getSavedOrderById(orderId);
    }

}
