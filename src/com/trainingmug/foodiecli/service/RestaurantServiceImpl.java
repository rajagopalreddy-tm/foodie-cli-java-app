package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.repository.RestaurantRepository;
import com.trainingmug.foodiecli.util.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        Optional<Restaurant> restaurantId = restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantId.isPresent()){
            throw new RestaurantAlreadyExistsException("Restaurant with ID: "+ restaurantId+" already exists !");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurant = restaurantRepository.findRestaurantById(id);
        if (restaurant.isEmpty()){
            throw  new RestaurantNotFoundException("Restaurant with ID: "+ id +" not found");
        }
        return restaurantRepository.getRestaurantById(id);
    }

    @Override
    public Restaurant edit(Restaurant restaurant, String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantId = restaurantRepository.findRestaurantById(id);
        if(restaurantId.isEmpty()){
            throw  new RestaurantNotFoundException("Restaurant with ID: "+ id +" not found");
        }
        return restaurantRepository.edit(restaurant,id);
    }

    @Override
    public void delete(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantId = restaurantRepository.findRestaurantById(id);
        if(restaurantId.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant with ID : "+id+" not found !");
        }
        restaurantRepository.delete(id);
    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        }

        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishService();

        for(String dishId : dishIds){
            Dish dish = dishService.getDishById(dishId);
            dishList.add(dish);
        }

        return dishList;
    }

}
