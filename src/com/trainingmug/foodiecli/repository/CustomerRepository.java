package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<Customer> getAllCustomers() {
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

    //find by email  //change the parameters with email and password
    public Optional<Customer> findCustomerByEmail(String email) {
        return customersList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }

    public Optional<Customer> findByEmailAndPassword(String email, String password){
        return this.customersList.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password))
                .findFirst();
    }

    //update
    public Customer edit(Customer customer, String id) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getId().equals(id)) {
                customersList.set(i, customer);
                return customer;
            }
        }
        return null;
    }

    //delete
    public void deleteCustomer(String id) {
        Iterator<Customer> customer = customersList.iterator();
        while (customer.hasNext()){
            Customer customerId = customer.next();
            if (customerId.getId().equals(id)){
                customer.remove();
                break;
            }
        }
    }



}