package com.example.restaurantPollBackend.exception;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(Long id) {
        super("Restaurant not available for id: " + id);
    }
}
