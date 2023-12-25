package com.example.restaurantPollBackend.service;

import com.example.restaurantPollBackend.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getAllRestaurants();
    public Restaurant getRestaurantChoice();
    public Restaurant createRestaurant(Restaurant restaurant);
    public String deleteRestaurant(Long id);
}
