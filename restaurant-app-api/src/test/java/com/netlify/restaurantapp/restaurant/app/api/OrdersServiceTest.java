package com.netlify.restaurantapp.restaurant.app.api;

import com.netlify.restaurantapp.restaurant.app.api.food.Food;
import com.netlify.restaurantapp.restaurant.app.api.food.FoodRepository;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.Orders;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersMapper;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersRepository;
import com.netlify.restaurantapp.restaurant.app.api.order.orders.OrdersService;
import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrder;
import com.netlify.restaurantapp.restaurant.app.api.order.savedOrder.CustomerSavedOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerSavedOrderRepository customerSavedOrderRepository;

    @Autowired
    private OrdersService ordersService;

    private Orders orders;

    private CustomerSavedOrder customerSavedOrder;

    private Food food;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrdersMapper ordersMapper;

    @BeforeEach
    void setUp() {
        orders = new Orders();
        customerSavedOrder = new CustomerSavedOrder();
    }

    @Test
    void deleteOrdersWithOrdersItems() {

        Food food = new Food();
        food.setName("Pizza");
        food.setPrice(14.0);
        food.setEmoji("🍕");
        food.setIngredients("Cheese, Tomato Sauce");

        foodRepository.save(food);

        orders.setStatus(Orders.Status.COMPLETED);

        customerSavedOrder.setFoodId(food.getFoodId());
        customerSavedOrder.setPrice(14.0);
        customerSavedOrder.setName("Pizza");
        customerSavedOrder.setOrder(orders);

        List<CustomerSavedOrder> customerSavedOrderList = new ArrayList<>();
        customerSavedOrderList.add(customerSavedOrder);

        orders.setCustomerSavedOrderList(customerSavedOrderList);

        ordersRepository.save(orders);
        customerSavedOrderRepository.save(customerSavedOrder);

        assertThat(ordersRepository.findById(orders.getOrdersId())).isPresent();

        assertThat(customerSavedOrderRepository.getSavedOrderById(orders.getOrdersId())).isNotEmpty();

        ordersService.deleteSavedOrderById(orders.getOrdersId());

        assertThat(ordersRepository.findById(orders.getOrdersId())).isEmpty();
    };

    @Test
    void testSaveOrders() {
        orders.setStatus(Orders.Status.PENDING);
        ordersService.saveOrders(orders);
        assertThat(ordersRepository.findById(orders.getOrdersId())).isPresent();
    }
}
