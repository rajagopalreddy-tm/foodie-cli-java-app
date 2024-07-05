package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.util.Factory;
import com.trainingmug.foodiecli.util.Validate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerSection {

    CustomerController customerController = Factory.getCustomerController();
    Validate validate = new Validate();

    public void signUpCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details:\n");

        System.out.println("Enter Id");
        String id = scanner.nextLine();
        Map<String, String> idValidation = validate.validateId(id);
        if (!idValidation.get("Id").equals("1")) {
            System.out.println(idValidation.get("Id"));
            return;
        }

        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Map<String, String> nameValidation = validate.validateName(name);
        if (!nameValidation.get("Name").equals("1")) {
            System.out.println(nameValidation.get("Name"));
            return;
        }

        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        Map<String, String> emailValidation = validate.validateEmail(email);
        if (!emailValidation.get("Email").equals("1")) {
            System.out.println(emailValidation.get("Email"));
            return;
        }

        System.out.println("Enter Password");
        String password = scanner.nextLine();
        Map<String, String> passwordValidation = validate.validatePassword(password);
        if (!passwordValidation.get("Password").equals("1")) {
            System.out.println(passwordValidation.get("Password"));
            return;
        }

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);

        try {
            Customer savedCustomer = customerController.save(customer);
            System.out.println("Sigh Up successful !");
            displayCustomerDetails(savedCustomer);
            System.out.println("\n\n");
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
            System.out.println("\n\n");
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewCustomers() {

        List<Customer> customersList = this.customerController.getAllCustomer();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Customers");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        System.out.println(dashesLine);
        customersList.forEach(customer ->
                System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length())));
        System.out.println("\n\n");
    }

    public void getCustomerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the Customer you want to search:");
        String id = scanner.nextLine();

        try {
            Customer customer = customerController.getCustomerById(id);
            displayCustomerDetails(customer);
            System.out.println("\n\n");
        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the ID of the Customer you want to Update:");
        String id = scanner.nextLine();

        System.out.println("Please update by entering the following updated customer details\n");

        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Map<String, String> nameValidation = validate.validateName(name);
        if (!nameValidation.get("Name").equals("1")) {
            System.out.println(nameValidation.get("Name"));
            return;
        }

        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        Map<String, String> emailValidation = validate.validateEmail(email);
        if (!emailValidation.get("Email").equals("1")) {
            System.out.println(emailValidation.get("Email"));
            return;
        }

        System.out.println("Enter Password");
        String password = scanner.nextLine();
        Map<String, String> passwordValidation = validate.validatePassword(password);
        if (!passwordValidation.get("Password").equals("1")) {
            System.out.println(passwordValidation.get("Password"));
            return;
        }

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);

        try {
            Customer customer1 = customerController.edit(customer, id);
            displayCustomerDetails(customer1);
            System.out.println("\n\n");
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
            System.out.println("\n\n");
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayCustomerDetails(Customer customer) {
        displayMenuHeader("Customer Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
        System.out.println("\n\n");
    }

    public void displayMenuHeader(String menuHeader) {
        printDashLine();
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        printDashLine();
    }

    public void printDashLine(){
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
    }

}
