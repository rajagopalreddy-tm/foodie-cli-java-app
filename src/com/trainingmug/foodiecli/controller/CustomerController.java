package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.java.Customer;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.service.CustomerServiceImpl;
import com.trainingmug.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws  CustomerAlreadyExistsException {
        return customerService.save(customer);
    }

}
