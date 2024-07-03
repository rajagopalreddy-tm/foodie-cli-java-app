package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.service.DishService;
import com.trainingmug.foodiecli.service.DishServiceImpl;

import java.util.List;

public class DishController {

    DishService dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public Dish addDish(Dish dish) throws DishAlreadyExistsException {
        return dishService.addDish(dish);
    }

    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }
}
