package com.food_delivery_system.food_delivery_system.service;

import com.food_delivery_system.food_delivery_system.model.MenuItem;
import com.food_delivery_system.food_delivery_system.model.OrderItem;
import com.food_delivery_system.food_delivery_system.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyService {

    // Method to select the lowest cost restaurant for a given order
    public Restaurant selectLowestCostRestaurant(List<OrderItem> orderItems, List<Restaurant> restaurants) {
        Restaurant selectedRestaurant = null;
        double lowestCost = Double.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {
            double totalCost = calculateTotalCost(orderItems, restaurant.getMenuItems());
            if (totalCost < lowestCost) {
                lowestCost = totalCost;
                selectedRestaurant = restaurant;
            }
        }

        return selectedRestaurant;
    }

    // Method to calculate the total cost of order items from a restaurant's menu
    private double calculateTotalCost(List<OrderItem> orderItems, List<MenuItem> menuItems) {
        double totalCost = 0.0;

        for (OrderItem orderItem : orderItems) {
            // Find the corresponding menu item
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getId().equals(orderItem.getMenuItem().getId())) {
                    totalCost += menuItem.getPrice() * orderItem.getQuantity();
                }
            }
        }

        return totalCost;
    }
}
