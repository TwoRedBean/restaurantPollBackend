package com.example.restaurantPollBackend.exception;

public class NoRestaurantCreatedException extends RuntimeException{
    public NoRestaurantCreatedException() {
        super("No restaurant created yet");
    }
}
