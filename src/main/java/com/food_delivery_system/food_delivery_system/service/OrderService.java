package com.food_delivery_system.food_delivery_system.service;

import com.food_delivery_system.food_delivery_system.model.Order;
import com.food_delivery_system.food_delivery_system.model.Restaurant;
import com.food_delivery_system.food_delivery_system.model.OrderItem;
import com.food_delivery_system.food_delivery_system.repo.OrderRepository;
import com.food_delivery_system.food_delivery_system.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository; // Injecting the Order repository

    @Autowired
    private RestaurantRepository restaurantRepository; // Injecting the Restaurant repository

    // Place a new order
    public Order placeOrder(Order order) {
        // Add logic to validate order items and check restaurant capacity
        // Example: Fetch the restaurant to check if it can fulfill the order
        Optional<Restaurant> restaurant = restaurantRepository.findById(order.getRestaurant().getId());
        if (restaurant.isPresent()) {
            // Check if the restaurant can fulfill the order based on its capacity
            // Add additional business logic here as needed
            return orderRepository.save(order); // Save the order to the database
        } else {
            throw new RuntimeException("Restaurant not found with ID: " + order.getRestaurant().getId());
        }
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll(); // Fetch all orders from the database
    }

    // Retrieve an order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id)); // Handle not found scenario
    }
}