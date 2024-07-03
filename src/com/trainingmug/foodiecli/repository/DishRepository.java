package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.util.Factory;

import java.util.Iterator;
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

    public Dish getDishById(String id) {
        Optional<Dish> dish = dishList.stream()
                .filter(dishId -> dishId.getId().equals(id))
                .findFirst();
        return dish.orElseThrow();
    }

    public Dish edit(Dish dish, String id) {
        for (int i = 0; i < dishList.size(); i++){
            if (dishList.get(i).getId().equals(id)) {
                dishList.set(i, dish);
                return dish;
            }
        }
        return null;
    }

    public void delete(String id) {
        Iterator<Dish> dish = dishList.iterator();
        while (dish.hasNext()){
            Dish dishId = dish.next();
            if(dishId.getId().equals(id)){
                dish.remove();
                break;
            }
        }
    }
}
