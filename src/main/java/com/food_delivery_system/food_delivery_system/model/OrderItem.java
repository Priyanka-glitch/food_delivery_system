package com.food_delivery_system.food_delivery_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each order item

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Foreign key reference to the order
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false) // Foreign key reference to the menu item
    private MenuItem menuItem;

    private int quantity; // Quantity of the menu item ordered

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
