package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface CustomerSavedOrderRepository extends JpaRepository<CustomerSavedOrder, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CustomerSavedOrder c WHERE c.orderId = :orderId AND c.foodId = :foodId")
    void deleteFoodItemFromSavedOrderById(@Param("orderId") Long ordersId, @Param("foodId") Long foodId);

    @Modifying
    @Transactional
    @Query("INSERT INTO CustomerSavedOrder c (c.orderId, c.foodId, c.price, c.name) VALUES (:orderId,:foodId,:foodItemPrice,:foodItemName)")
    void addFoodItemToOrder(@Param("orderId") Long orderId,
                            @Param("foodId") Long foodId,
                            @Param("foodItemPrice") Double foodItemPrice,
                            @Param("foodItemName") String foodItemName);
    @Modifying
    @Transactional
    @Query("SELECT c FROM CustomerSavedOrder c WHERE orderId = :orderId")
    List<CustomerSavedOrder> getSavedOrderById(@Param("orderId") Long orderId);
}
