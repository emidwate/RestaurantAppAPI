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

    @PostMapping("/saveOrder")
    public void saveOrder(@Valid @RequestBody List<CustomerSavedOrder> savedOrderList,
                          @RequestParam String status) {
        savedOrderService.saveOrder(savedOrderList, status);
    }

    @DeleteMapping("/deleteFoodItemFromSavedOrderById/{orderId}/food/{foodId}")
    public void deleteFoodItemFromSavedOrderById(@PathVariable("orderId") Long orderId,
                                                 @PathVariable("foodId") Long foodId) {
        savedOrderService.deleteFoodItemFromSavedOrderById(orderId, foodId);
    }

    @PutMapping("/addNewFoodItemToSavedOrderById/{orderId}/food/{foodId}")
    public void addNewFoodItemToSavedOrderById(@PathVariable("orderId") Long orderId,
                                               @PathVariable("foodId") Long foodId) {
        savedOrderService.addFoodItemToSavedOrderById(orderId, foodId);
    }

    @GetMapping("/getSavedOrderById/{orderId}")
    public List<CustomerSavedOrder> getSavedOrder(@PathVariable("orderId") Long orderId) {
        return savedOrderService.getSavedOrderById(orderId);
    }

    @DeleteMapping("/deleteSavedOrderById/{id}")
    public void deleteSavedOrderById(@PathVariable("id") Long id) {
        savedOrderService.deleteSavedOrderById(id);
    }

}
