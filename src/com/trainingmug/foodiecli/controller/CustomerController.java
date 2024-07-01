package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.service.CustomerService;

public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        return customerService.save(customer);
    }

}
