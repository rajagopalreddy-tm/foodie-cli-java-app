package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.java.Dish;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DishRepository {

    private CsvReader csvReader = new CsvReader();

    private List<Dish> dishList = new ArrayList<>();

    // Get all dishes
    public List<Dish> getDishes() {
        return dishList;
    }

    // Add dish
    public void addDishToList(Dish dish) throws DishAlreadyExistsException {
        Optional<Dish> existingDish = dishList.stream()
                .filter(d -> d.getId().equals(dish.getId()))
                .findFirst();
        if (existingDish.isPresent()) {
            throw new DishAlreadyExistsException("Dish with id " + dish.getId() + " already exists.");
        }
        dishList.add(dish);
    }

    //get dish by id
    public Optional<Dish> getDishById(String id) {
        return dishList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }


//    public Dish addDish(Dish dish) throws DishAlreadyExistsException {
//        Optional<Dish> existingDish = dishList.stream()
//                .filter(d -> d.getId().equals(dish.getId()))
//                .findFirst();
//        if (existingDish.isPresent()) {
//            throw new DishAlreadyExistsException("Dish with id " + dish.getId() + " already exists.");
//        }
//        dishList.add(dish);
//        return dish;
//    }

}
