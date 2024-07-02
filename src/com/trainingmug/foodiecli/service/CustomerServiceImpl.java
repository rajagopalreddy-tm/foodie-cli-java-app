package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getALlCustomer() {
        return  customerRepository.getAllCustomers();
    }

    @Override
    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> customerId = customerRepository.findCustomerById(customer.getId());
        if (customerId.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with ID " + customer.getId() + " already exists.");
        }
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer edit(Customer customer,String id) throws CustomerNotFoundException {
        Optional<Customer> customerEmail = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerEmail.isEmpty()) {
            throw new CustomerNotFoundException("Customer with Email " + customer.getEmail() + " not found.");
        }
        return customerRepository.edit(customer,id);
    }

    @Override
    public void delete(String id) throws CustomerNotFoundException {
        Optional<Customer> customerId = customerRepository.findCustomerById(id);
        if (customerId.isEmpty()) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        customerRepository.deleteCustomer(id);
    }


}
