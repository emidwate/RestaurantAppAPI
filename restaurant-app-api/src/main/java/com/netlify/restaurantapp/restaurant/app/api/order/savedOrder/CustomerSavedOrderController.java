package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerSavedOrderController {
    private final CustomerSavedOrderService savedOrderService;
    private final CustomerSavedOrderMapper customerSavedOrderMapper;

    public CustomerSavedOrderController(CustomerSavedOrderService savedOrderService,
                                        CustomerSavedOrderMapper customerSavedOrderMapper) {
        this.savedOrderService = savedOrderService;
        this.customerSavedOrderMapper = customerSavedOrderMapper;
    }

    @PostMapping("/order")
    public void saveOrder(@Valid @RequestBody List<CustomerSavedOrderDTO> savedOrderList,
                          @RequestParam String status) {
                savedOrderService.saveOrder(savedOrderList.stream()
                .map(customerSavedOrderMapper::toEntity)
                .collect(Collectors.toList())
                ,status);
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
    public List<CustomerSavedOrderDTO> getSavedOrderById(@PathVariable("orderId") Long orderId) {
        return savedOrderService.getSavedOrderById(orderId)
                .stream()
                .map(customerSavedOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

}
