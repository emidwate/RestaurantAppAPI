package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE customer_order", nativeQuery = true)
    void truncateOrderTable();
}
