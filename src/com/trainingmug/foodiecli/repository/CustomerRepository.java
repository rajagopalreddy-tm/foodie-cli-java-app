package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    List<Customer> customersList;

    public CustomerRepository() {
        this.customersList = new ArrayList<>();
        CsvReader csvReader = new CsvReader();
        this.customersList = csvReader.readCustomers();
    }

    //get customers
    public List<Customer> getCustomersList() {
        return this.customersList;
    }

    // save
    public Customer saveCustomer(Customer customer) {
        customersList.add(customer);
        return customer;
    }

    //find by id
    public Optional<Customer> findCustomerById(String customerId) {
        return customersList.stream()
                        .filter(customer -> customer.getId().equals(customerId))
                        .findFirst();
    }

}
