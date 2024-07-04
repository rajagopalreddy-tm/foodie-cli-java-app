package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Restaurant;

import java.util.List;

public interface DishService {

    Dish addDish(Dish dish) throws DishAlreadyExistsException;
    List<Dish> getAllDishes();
    Dish getDishById(String id) throws DishNotFoundException;
    Dish edit(Dish dish, String id) throws DishNotFoundException;
    void delete(String id) throws DishNotFoundException;

}
