package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersRepository;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersService;
import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrderRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrdersServiceTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerSavedOrderRepository customerSavedOrderRepository;

    @Autowired
    private OrdersService ordersService;

    @Test
    void testSaveOrderToDatabase() {
        Orders orders = new Orders();
        orders.setStatus(Orders.Status.COMPLETED);

        CustomerSavedOrder customerSavedOrder = new CustomerSavedOrder();
        customerSavedOrder.setFoodId(1L);
        customerSavedOrder.setPrice(14.0);
        customerSavedOrder.setName("Pizza");
        customerSavedOrder.setOrder(orders);

        List<CustomerSavedOrder> customerSavedOrderList = new ArrayList<>();
        customerSavedOrderList.add(customerSavedOrder);

        orders.setCustomerSavedOrderList(customerSavedOrderList);

        ordersRepository.save(orders);
        customerSavedOrderRepository.save(customerSavedOrder);

        assertThat(ordersRepository.findById(orders.getOrdersId()).isPresent()).isTrue();

        assertThat(customerSavedOrderRepository.getSavedOrderById(orders.getOrdersId())).isNotEmpty();

        ordersService.deleteSavedOrderById(orders.getOrdersId());

        assertThat(ordersRepository.findById(orders.getOrdersId()).isEmpty()).isTrue();
    };
}
