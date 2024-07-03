package com.trainingmug.foodiecli.util;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.controller.DishController;
import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import com.trainingmug.foodiecli.repository.DishRepository;
import com.trainingmug.foodiecli.repository.RestaurantRepository;
import com.trainingmug.foodiecli.service.*;

public class Factory {

    public static CsvReader getCsvReader(){
        return new CsvReader();
    }

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }


    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }


    public static DishRepository getDishRepository(){
        return new DishRepository();
    }

    public static DishServiceImpl getDishService() {
        return new DishServiceImpl(getDishRepository());
    }

    public static DishController getDishController(){
        return new DishController(getDishService());
    }

}
