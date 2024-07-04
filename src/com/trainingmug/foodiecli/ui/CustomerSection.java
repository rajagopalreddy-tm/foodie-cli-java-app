package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.util.Factory;

import java.util.List;
import java.util.Scanner;

public class CustomerSection {

    CustomerController customerController = Factory.getCustomerController();


    public void signUpCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details:\n");
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);

        try {
            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            System.out.println("Details:");
            System.out.println("Id : " + savedCustomer.getId());
            System.out.println("Name : " + savedCustomer.getName());
            System.out.println("E-mail : " + savedCustomer.getEmail());
            System.out.println("Password : " + savedCustomer.getPassword());
        } catch (CustomerAlreadyExistsException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void loginCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Login entering the following details\n");

        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();

        try {

            Customer customer = customerController.login(email , password);
            System.out.println("Customer Login Successful with Email: "+ customer.getEmail());
            System.out.println("Welcome "+ customer.getName());
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewCustomers() {
        System.out.println("------------------------");
        List<Customer> customerList = customerController.getAllCustomer();
        for (Customer customer : customerList) {
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("------------------------");
        }
    }

    public void getCustomerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the Customer you want to search:");
        String id = scanner.nextLine();

        try {
            Customer customer = customerController.getCustomerById(id);
            System.out.println("Customer Details:");
            System.out.println("Name: " + customer.getName());
            System.out.println("E-mail: " + customer.getEmail());
        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the ID of the Customer you want to Update:");
        String id = scanner.nextLine();

        System.out.println("Please update by entering the following updated customer details\n");

        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter E-mail:");
        String email = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);

        try {
            customerController.edit(customer, id);
            System.out.println("Customer updated successfully.");
            System.out.println("Updated Details:");
            System.out.println("Id : " + id);
            System.out.println("Name : " + customer.getName());
            System.out.println("E-mail : " + customer.getEmail());
            System.out.println("Password : " + customer.getPassword());
        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the customer you want to delete");
        String id = scanner.nextLine();

        try{
            customerController.delete(id);
            System.out.println("Customer with ID: "+id+" deleted successfully !");
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
