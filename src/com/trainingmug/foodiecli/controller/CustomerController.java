package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.service.CustomerService;

import java.util.List;

public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        return customerService.save(customer);
    }

    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    public Customer login(Customer customer) throws CustomerNotFoundException {
        return customerService.login(customer);
    }

    public Customer edit(Customer customer, String id) throws CustomerNotFoundException {
        return customerService.edit(customer,id);
    }

    public void delete(String id) throws CustomerNotFoundException {
        customerService.delete(id);
    }

}
