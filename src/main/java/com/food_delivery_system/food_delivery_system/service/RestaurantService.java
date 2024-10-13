package com.food_delivery_system.food_delivery_system.service;

import com.food_delivery_system.food_delivery_system.model.Restaurant;
import com.food_delivery_system.food_delivery_system.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository; // Injecting the repository

    // Register a new restaurant
    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant); // Save the restaurant to the database
    }

    // Update an existing restaurant's menu
    public Restaurant updateRestaurantMenu(Long id, Restaurant restaurantDetails) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
        if (existingRestaurant.isPresent()) {
            Restaurant restaurant = existingRestaurant.get();
            restaurant.setName(restaurantDetails.getName());
            restaurant.setCapacity(restaurantDetails.getCapacity());
            restaurant.setRating(restaurantDetails.getRating());
            restaurant.setMenuItems(restaurantDetails.getMenuItems()); // Assuming menu items are included in the update
            return restaurantRepository.save(restaurant); // Save the updated restaurant
        } else {
            throw new RuntimeException("Restaurant not found with id: " + id); // Handle not found scenario
        }
    }

    // Retrieve all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll(); // Fetch all restaurants from the database
    }

    // Retrieve a restaurant by ID
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id)); // Handle not found scenario
    }
}
