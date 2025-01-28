package com.netlify.restaurantapp.restaurant.app.api.order.orders;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Orders o WHERE o.id = :id")
    void deleteSavedOrderById(Long id);
}
