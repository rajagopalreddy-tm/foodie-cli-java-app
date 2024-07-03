package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomer();
    public Customer save(Customer customer) throws CustomerAlreadyExistsException;
    Customer getCustomerById(String id) throws CustomerNotFoundException;
    Customer login(Customer customer) throws CustomerNotFoundException;
    public Customer edit(Customer customer,String id) throws CustomerNotFoundException;
    public void delete(String id) throws CustomerNotFoundException;

}
