package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.service.RestaurantService;

import java.util.List;

public class RestaurantController {
    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        return restaurantService.save(restaurant);
    }

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return restaurantService.getRestaurantById(id);
    }

    public Restaurant edit(Restaurant restaurant, String id) throws RestaurantNotFoundException {
        return restaurantService.edit(restaurant,id);
    }

    public void delete(String id) throws RestaurantNotFoundException{
        restaurantService.delete(id);
    }

}
