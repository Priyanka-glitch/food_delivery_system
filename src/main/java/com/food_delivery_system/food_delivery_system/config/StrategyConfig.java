package com.food_delivery_system.food_delivery_system.config;

import com.food_delivery_system.food_delivery_system.strategy.LowestCosts;
import org.springframework.context.annotation.Bean;

public class StrategyConfig {
    @Bean
    public LowestCosts selectionStrategy() {
        // Return the desired strategy implementation
        return new LowestCosts(); // Change to any strategy implementation as needed
    }
}
