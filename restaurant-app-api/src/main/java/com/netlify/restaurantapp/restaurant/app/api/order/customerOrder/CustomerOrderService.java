package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getOrder() {
        List<CustomerOrder> customerOrder = customerOrderRepository.findAll();
        return new ArrayList<>(customerOrder);
    }

    public void addItemToOrder(CustomerOrder order) {
        customerOrderRepository.save(order);
    }

    public void deleteItemFromOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }

    public void truncateOrderTable() {
        customerOrderRepository.truncateOrderTable();
    }
}
