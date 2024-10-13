package com.food_delivery_system.food_delivery_system.strategy;

import com.food_delivery_system.food_delivery_system.model.OrderItem;
import com.food_delivery_system.food_delivery_system.model.MenuItem;
import com.food_delivery_system.food_delivery_system.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LowestCosts implements Selection {

    @Override
    public Restaurant selectRestaurant(List<OrderItem> orderItems, List<Restaurant> restaurants) {
        Restaurant selectedRestaurant = null;
        double lowestCost = Double.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {
            double totalCost = calculateTotalCost(orderItems, restaurant.getMenuItems());
            if (totalCost < lowestCost) {
                lowestCost = totalCost;
                selectedRestaurant = restaurant; // Update the selected restaurant
            }
        }

        return selectedRestaurant; // Return the restaurant with the lowest cost
    }

    // Calculate the total cost of the order based on the restaurant's menu
    private double calculateTotalCost(List<OrderItem> orderItems, List<MenuItem> menuItems) {
        double totalCost = 0.0;

        for (OrderItem orderItem : orderItems) {
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getId().equals(orderItem.getMenuItem().getId())) {
                    totalCost += menuItem.getPrice() * orderItem.getQuantity(); // Calculate the total cost
                }
            }
        }

        return totalCost; // Return the total cost calculated
    }
}
