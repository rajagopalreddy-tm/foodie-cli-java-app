package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.util.CsvReader;
import com.trainingmug.foodiecli.util.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DishRepository {

    List<Dish> dishList;
    public DishRepository() {
        this.dishList = Factory.getCsvReader().readDishes();
    }

    public Optional<Dish> findDishById(String id) {
        return dishList.stream()
                .filter(dishId -> dishId.getId().equals(id))
                .findFirst();
    }

    public Dish addDish(Dish dish) {
        dishList.add(dish);
        return dish;
    }

    public List<Dish> getAllDishes() {
        return this.dishList;
    }

}
