package com.example.restaurantPollBackend.controller;

import com.example.restaurantPollBackend.model.Restaurant;
import com.example.restaurantPollBackend.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping(path = "/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping()
    @Operation(summary = "Get all restaurants", description = "Returns all restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantService.getAllRestaurants());
    }

    @GetMapping("/restaurant")
    @Operation(summary = "Get random restaurant", description = "Returns a random restaurant selection")
    public ResponseEntity<Restaurant> getRestaurantChoice() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantService.getRestaurantChoice());
    }

    @PostMapping("/restaurant")
    @Operation(summary = "Create restaurant", description = "Creates a restaurant using restaurant name")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantService.createRestaurant(restaurant));
    }

    @DeleteMapping("/restaurant/{id}")
    @Operation(summary = "Delete restaurant", description = "Removes a restaurant by id")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantService.deleteRestaurant(id));
    }
}
