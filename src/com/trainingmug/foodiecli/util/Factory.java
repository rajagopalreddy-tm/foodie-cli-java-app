package com.trainingmug.foodiecli.util;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import com.trainingmug.foodiecli.repository.RestaurantRepository;
import com.trainingmug.foodiecli.service.CustomerServiceImpl;
import com.trainingmug.foodiecli.service.RestaurantService;
import com.trainingmug.foodiecli.service.RestaurantServiceImpl;

public class Factory {

    static CustomerRepository customerRepository;
    static CustomerServiceImpl customerServiceImpl;
    static CustomerController customerController;

    static RestaurantRepository restaurantRepository;
    static RestaurantService restaurantServiceImpl;
    static RestaurantController restaurantController;

    public static CustomerRepository getCustomerRepository(){
        customerRepository = new CustomerRepository();
        return customerRepository;
    }

    public static CustomerServiceImpl getCustomerServiceImpl(){
        customerServiceImpl = new CustomerServiceImpl(getCustomerRepository());
            return customerServiceImpl;
    }

    public static CustomerController getCustomerController(){
        customerController = new CustomerController(getCustomerServiceImpl());
        return customerController;
    }

    public static RestaurantRepository getRestaurantRepository(){
        restaurantRepository = new RestaurantRepository();
        return restaurantRepository;
    }

    public static RestaurantServiceImpl getRestaurantServiceImpl(){
        restaurantServiceImpl = new RestaurantServiceImpl(getRestaurantRepository());
        return (RestaurantServiceImpl) restaurantServiceImpl;
    }

    public static RestaurantController getRestaurantController(){
        restaurantController = new RestaurantController(getRestaurantServiceImpl());
        return restaurantController;
    }

}
