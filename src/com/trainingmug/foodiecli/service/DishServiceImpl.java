package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Restaurant;
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


    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        return dishRepository.findDishById(id)
                .orElseThrow(() -> new DishNotFoundException("Dish not found with ID: " + id));
    }

    @Override
    public Dish edit(Dish dish, String id) throws DishNotFoundException {
        Optional<Dish> dishId = dishRepository.findDishById(id);
        if(dishId.isEmpty()){
            throw new DishNotFoundException("Dish with ID: "+id+" not found ");
        }
        return dishRepository.edit(dish, id);
    }

    @Override
    public void delete(String id) throws DishNotFoundException {
        Optional<Dish> dishId = dishRepository.findDishById(id);
        if(dishId.isEmpty()){
            throw new DishNotFoundException("Dish with ID: "+id+" not found  ");
        }
        dishRepository.delete(id);
    }
}
