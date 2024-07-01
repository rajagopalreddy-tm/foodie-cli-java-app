package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.java.Customer;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> customerId = customerRepository.findCustomerById(customer.getId());
        if (customerId.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with ID " + customer.getId() + " already exists.");
        }
        return customerRepository.saveCustomer(customer);
    }

}
