package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getALlCustomer();
    public Customer save(Customer customer) throws CustomerAlreadyExistsException;
    public Customer edit(Customer customer,String id) throws CustomerNotFoundException;
    public void delete(String id) throws CustomerNotFoundException;


//    public Customer loin(Customer customer) throws CustomerNotFoundException;
}
