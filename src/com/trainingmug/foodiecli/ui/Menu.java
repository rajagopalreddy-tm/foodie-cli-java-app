package com.trainingmug.foodiecli.ui;
import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.factory.Factory;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;
import java.util.Scanner;

public class Menu {

    CustomerController customerController = Factory.getCustomerController();

    public void displayMainMenu() {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO FOODIE APP                             ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Customers Section");
            System.out.println("2. Restaurants Section");
            System.out.println("3. Orders Section");
            System.out.println("4. Exit");

            System.out.println("Please enter your choice (1-4)");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    displayCustomerSection();
                    break;
                default:
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");

            }
        }
    }


    private void displayCustomerSection() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO Customers Section                      ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. View Customers");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("Please enter your choice (1-5)");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    displaySignUp();
                    break;
                case 2:
                    displayLogin();
                    break;
                case 3:
                    viewCustomers();
                    break;
                case 4:
                    updateCustomer();
                    break;
//                case 5:
//                    deleteCustomer();
//                    break;
                default:
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");
            }
        }
    }

    private void displaySignUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details\n");
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
            System.out.println(e.getMessage());
        }
    }
    
    private void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details\n");
        
        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        
        Customer customer = new Customer();
        customer.setEmail(email)
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
            System.out.println(e.getMessage());
        }
    }
    public void viewCustomers() {
        try {
            List<Customer> customerList = customerController.getAllCustomer();
            for (Customer customer : customerList) {
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the ID of the customer you want to update:");
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
            Customer customerUpdate = customerController.edit(customer, id);
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

}
