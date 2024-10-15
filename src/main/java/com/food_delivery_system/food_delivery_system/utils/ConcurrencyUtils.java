package com.food_delivery_system.food_delivery_system.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyUtils {

    // A map to manage locks for each restaurant to avoid race conditions when processing orders
    private static final ConcurrentHashMap<Long, Lock> restaurantLocks = new ConcurrentHashMap<>();

    public static Lock getRestaurantLock(Long restaurantId) {
        // Ensure only one lock per restaurant ID (thread-safe)
        return restaurantLocks.computeIfAbsent(restaurantId, id -> new ReentrantLock());
    }

    /**
     * Acquire a lock for a restaurant before processing an order to ensure no over-capacity.
     *
     * @param restaurantId The ID of the restaurant to lock.
     * @return true if the lock was acquired, false otherwise.
     */
    public static boolean acquireLock(Long restaurantId) {
        Lock lock = getRestaurantLock(restaurantId);
        return lock.tryLock(); // Attempt to acquire the lock
    }

    /**
     * Release the lock for a restaurant after processing the order.
     *
     * @param restaurantId The ID of the restaurant to unlock.
     */
    public static void releaseLock(Long restaurantId) {
        Lock lock = getRestaurantLock(restaurantId);
        if (lock.isHeldByCurrentThread()) {
            lock.unlock(); // Only unlock if the current thread holds the lock
        }
    }

    /**
     * Remove the lock for a restaurant (e.g., after the restaurant is removed from the system).
     *
     * @param restaurantId The ID of the restaurant to remove the lock for.
     */
    public static void removeLock(Long restaurantId) {
        restaurantLocks.remove(restaurantId); // Remove the lock mapping
    }
}
