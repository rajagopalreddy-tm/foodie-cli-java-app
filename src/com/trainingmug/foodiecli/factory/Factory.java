package com.trainingmug.foodiecli.factory;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.service.CustomerServiceImpl;

public class Factory {

    static CustomerRepository customerRepository;
    static CustomerServiceImpl customerServiceImpl;
    static CustomerController customerController;

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

}
