package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerAlreadyExistsException;
}
