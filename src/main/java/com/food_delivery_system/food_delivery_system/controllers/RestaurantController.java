package com.food_delivery_system.food_delivery_system.controllers;

import com.food_delivery_system.food_delivery_system.model.Restaurant;
import com.food_delivery_system.food_delivery_system.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Endpoint to register a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.registerRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }

    // Endpoint to update an existing restaurant's menu
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurantMenu(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurantMenu(id, restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // Endpoint to get a list of all restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    // Endpoint to get a specific restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }
}