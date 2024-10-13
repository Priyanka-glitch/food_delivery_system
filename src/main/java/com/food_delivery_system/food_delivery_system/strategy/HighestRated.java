package com.food_delivery_system.food_delivery_system.strategy;

import com.food_delivery_system.food_delivery_system.model.OrderItem;
import com.food_delivery_system.food_delivery_system.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HighestRated implements Selection {

    @Override
    public Restaurant selectRestaurant(List<OrderItem> orderItems, List<Restaurant> restaurants) {
        Restaurant selectedRestaurant = null;

        for (Restaurant restaurant : restaurants) {
            // Assume all restaurants can fulfill the order (additional checks can be implemented if needed)
            if (selectedRestaurant == null || restaurant.getRating() > selectedRestaurant.getRating()) {
                selectedRestaurant = restaurant; // Update the selected restaurant
            }
        }

        return selectedRestaurant; // Return the restaurant with the highest rating
    }
}