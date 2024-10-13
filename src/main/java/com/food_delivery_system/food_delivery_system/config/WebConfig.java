package com.food_delivery_system.food_delivery_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Optional: Enable Spring MVC features
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configure CORS settings
        registry.addMapping("/**") // Allow all paths
                .allowedOrigins("http://localhost:3000") // Change this to your frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowCredentials(true); // Allow credentials (e.g., cookies)
    }
}
