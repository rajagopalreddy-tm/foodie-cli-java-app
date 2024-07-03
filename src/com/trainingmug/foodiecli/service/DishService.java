package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.model.Dish;

import java.util.List;

public interface DishService {
    Dish addDish(Dish dish) throws DishAlreadyExistsException;

    List<Dish> getAllDishes();
}
