package com.example.restaurantPollBackend.service.controller;

import com.example.restaurantPollBackend.exception.NoRestaurantCreatedException;
import com.example.restaurantPollBackend.exception.RestaurantNotFoundException;
import com.example.restaurantPollBackend.model.Restaurant;
import com.example.restaurantPollBackend.repository.RestaurantRepository;
import com.example.restaurantPollBackend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantChoice() {
        Random r = new Random();
        List<Restaurant> restaurantList = getAllRestaurants();
        return restaurantList
                .stream()
                .skip(r.nextInt(restaurantList.size() == 0 ? 1 : restaurantList.size()))
                .findFirst()
                .orElseThrow(() -> new NoRestaurantCreatedException());
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public String deleteRestaurant(Long id) {
        if(!restaurantRepository.existsById(id)) {
            throw new RestaurantNotFoundException(id);
        }
        restaurantRepository.deleteById(id);
        return "Restaurant deleted for id: " + id;
    }
}
