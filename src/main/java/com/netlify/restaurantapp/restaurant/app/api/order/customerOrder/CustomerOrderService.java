package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository orderRepository;

    public CustomerOrderService(CustomerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<CustomerOrder> getOrder() {
        return orderRepository.findAll();
    }

    public void addItemToOrder(CustomerOrder order) {
        orderRepository.save(order);
    }

    public void deleteItemFromOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void truncateOrderTable() {
        orderRepository.truncateOrderTable();
    }

}
