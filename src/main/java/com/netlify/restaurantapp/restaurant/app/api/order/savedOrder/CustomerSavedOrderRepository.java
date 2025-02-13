package com.netlify.restaurantapp.restaurant.app.api.order.savedOrder;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerSavedOrderRepository extends JpaRepository<CustomerSavedOrder, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CustomerSavedOrder c WHERE c.order.ordersId = :orderId AND c.foodId = :foodId")
    void deleteFoodItemFromSavedOrderById(@Param("orderId") Long orderId, @Param("foodId") Long foodId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO saved_order (order_id, food_id, price, name) VALUES " +
                   "(:orderId, :foodId, :foodItemPrice, :foodItemName)", nativeQuery = true)
    void addFoodItemToSavedOrderById(@Param("orderId") Long orderId,
                                     @Param("foodId") Long foodId,
                                     @Param("foodItemPrice") Double foodItemPrice,
                                     @Param("foodItemName") String foodItemName);

    @Query("SELECT c FROM CustomerSavedOrder c WHERE c.order.ordersId = :orderId")
    List<CustomerSavedOrder> getSavedOrderById(@Param("orderId") Long orderId);
}
