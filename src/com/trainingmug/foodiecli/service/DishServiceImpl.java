package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements  DishService {

    DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish addDish(Dish dish) throws DishAlreadyExistsException {
        Optional<Dish> dishId = dishRepository.findDishById(dish.getId());
        if(dishId.isPresent()){
            throw new DishAlreadyExistsException("Dish with ID: "+dish.getId()+" already exist.");
        }
        return dishRepository.addDish(dish);
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.getAllDishes();
    }
}
