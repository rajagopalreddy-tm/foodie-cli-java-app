package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();
    Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException;
    Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;
    Restaurant edit(Restaurant restaurant,String id) throws RestaurantNotFoundException;
    void delete(String id) throws RestaurantNotFoundException;

}
