package com.netlify.restaurantapp.restaurant.app.api.order.customerOrder;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository,
                                CustomerOrderMapper customerOrderMapper) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderMapper = customerOrderMapper;
    }

    public List<CustomerOrderDTO> getOrder() {
        List<CustomerOrder> customerOrder = customerOrderRepository.findAll();

        return customerOrder.stream()
                .map(customerOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void addItemToOrder(CustomerOrderDTO orderDTO) {
        CustomerOrder customerOrder = customerOrderMapper.toEntity(orderDTO);
        customerOrderRepository.save(customerOrder);
    }


    public void deleteItemFromOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }

    public void truncateOrderTable() {
        customerOrderRepository.truncateOrderTable();
    }
}
