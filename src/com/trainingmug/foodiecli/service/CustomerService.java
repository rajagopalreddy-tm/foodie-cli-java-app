package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();
    Customer save(Customer customer) throws CustomerAlreadyExistsException;
    Customer getCustomerById(String id) throws CustomerNotFoundException;
    Customer edit(Customer customer, String id) throws CustomerNotFoundException;
    void delete(String id) throws CustomerNotFoundException;
    Customer login(String email, String password) throws CustomerNotFoundException;
    void setCurrentLogin(Customer customer);
    Customer getCurrentLogin();
}
