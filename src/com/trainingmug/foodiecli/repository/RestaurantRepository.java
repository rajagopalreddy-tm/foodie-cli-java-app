package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class RestaurantRepository {

    List<Restaurant> restaurantList;

    public RestaurantRepository (){
        this.restaurantList = new ArrayList<>();
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurants();
    }

    public List<Restaurant> getAllRestaurants(){
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant){
        restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurantById(String restaurantId){
        return restaurantList.stream()
                .filter(restaurant -> restaurant.getId().equals(restaurantId))
                .findFirst();
    }

    public Restaurant getRestaurantById(String id) {
        Optional<Restaurant> restaurant = restaurantList.stream()
                .filter(restaurantId -> restaurantId.getId().equals(id))
                .findFirst();
        return  restaurant.orElseThrow();
    }

    public Restaurant edit(Restaurant restaurant, String id){
        for (int i = 0; i < restaurantList.size(); i++){
            if (restaurantList.get(i).getId().equals(id)) {
                restaurantList.set(i, restaurant);
                return restaurant;
            }
        }
        return null;
    }

    public void delete(String id){
        Iterator<Restaurant> restaurant = restaurantList.iterator();
        while (restaurant.hasNext()){
            Restaurant restaurantId = restaurant.next();
            if(restaurantId.getId().equals(id)){
                restaurant.remove();
                break;
            }
        }
    }

}
