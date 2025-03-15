package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodRepository;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerSavedOrderService {

    private final CustomerSavedOrderRepository customerSavedOrderRepository;
    private final OrdersRepository ordersRepository;
    private final FoodRepository foodRepository;

    public CustomerSavedOrderService(
            CustomerSavedOrderRepository savedOrderRepository,
            OrdersRepository orderRepository,
            FoodRepository foodRepository
    ) {
        this.customerSavedOrderRepository = savedOrderRepository;
        this.ordersRepository = orderRepository;
        this.foodRepository = foodRepository;
    }

    public void saveOrder(List<CustomerSavedOrder> savedOrderList, String status) {
        if (savedOrderList == null || savedOrderList.isEmpty()) {
            throw new IllegalArgumentException("Saved order list cannot be null or empty");
        }
        Orders newOrder = new Orders();
        newOrder.setStatus(Orders.Status.valueOf(status.toUpperCase()));
        Orders savedOrderEntry = ordersRepository.save(newOrder);
        for (CustomerSavedOrder savedOrderItem : savedOrderList) {
            savedOrderItem.setOrder(savedOrderEntry);
        }
        customerSavedOrderRepository.saveAll(savedOrderList);
    }

    public void deleteFoodItemFromSavedOrderById(Long orderId, Long foodId) {
        Orders orders = ordersRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Food with ID " + orderId + " not found"));
        if(Orders.Status.ORDERED.toString().equals(orders.getStatus().toString())){
            customerSavedOrderRepository.deleteFoodItemFromSavedOrderById(orderId, foodId);
        } else {
            throw new IllegalArgumentException("Can not delete food item from saved order. " +
                    "The status must be ORDERED not " + orders.getStatus().toString());
        }
    }

    public void addFoodItemToSavedOrderById(Long orderId, Long foodId) {
        Orders orders = ordersRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Food with ID " + orderId + " not found"));
        if(Orders.Status.ORDERED.toString().equals(orders.getStatus().toString())){
            Food foodItem = foodRepository.findById(foodId).orElseThrow(() ->
                    new IllegalArgumentException("Food with ID " + foodId + " not found"));
            String foodItemName = foodItem.getName();
            Double foodItemPrice = foodItem.getPrice();
            customerSavedOrderRepository.addFoodItemToSavedOrderById(orderId, foodId, foodItemPrice, foodItemName);
        } else {
            throw new IllegalArgumentException("Can not add food item to saved order. " +
                    "The status must be ORDERED not " + orders.getStatus().toString());
        }
    }

    public List<CustomerSavedOrder> getSavedOrderById(Long orderId) {
        return customerSavedOrderRepository.getSavedOrderById(orderId);
    }
}
