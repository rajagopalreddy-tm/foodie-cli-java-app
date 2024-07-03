package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.util.Factory;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RestaurantSection {

    static RestaurantController restaurantController = Factory.getRestaurantController();
    static Scanner scanner = new Scanner(System.in);

    public void addRestaurant(){

        System.out.println("Add a Restaurant entering the following details\n");
        System.out.println("Enter ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter Menu:");
        String menu = scanner.nextLine();

        Restaurant restaurant = new Restaurant();
        restaurant.setId(id)
                .setName(name)
                .setAddress(address)
                .setMenu(Collections.singletonList(menu));

        try {
            Restaurant restaurantSave = restaurantController.save(restaurant);
            System.out.println("Restaurant add successfully !");
            System.out.println("Details:");
            System.out.println("Restaurant ID:" + restaurantSave.getId());
            System.out.println("Restaurant Name:" + restaurantSave.getName());
            System.out.println("Restaurant Address:" + restaurantSave.getAddress());
            System.out.println("Restaurant Menu:" + restaurantSave.getMenu());
        } catch (RestaurantAlreadyExistsException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void viewRestaurants() {
        try {
            System.out.println("------------------------");
            System.out.println("List of all Restaurants");
            List<Restaurant> restaurantList = restaurantController.getAllRestaurants();
            for (Restaurant restaurant : restaurantList) {
                System.out.println("Restaurant ID: "+ restaurant.getId());
                System.out.println("Restaurant Name: "+ restaurant.getName());
                System.out.println("Restaurant Address: "+ restaurant.getAddress());
                System.out.println("Restaurant Menu: "+ restaurant.getMenu());
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void searchRestaurant() {

        System.out.println("Please enter the ID of the Restaurant you want to search:");
        String id = scanner.nextLine();

        try{
            Restaurant restaurant = restaurantController.getRestaurantById(id);
            System.out.println("Restaurant Details:");
            System.out.println("ID: " + restaurant.getId());
            System.out.println("Name: " + restaurant.getName());
            System.out.println("E-mail: " + restaurant.getAddress());
            System.out.println("Menu: " + restaurant.getMenu());
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public static void updateRestaurant() {
        System.out.println("Please enter the ID of the Restaurant you want to update:");
        String id = scanner.nextLine();

        System.out.println("Please enter updated Restaurant details:\n");

        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Menu: ");
        String menu = scanner.nextLine();

        Restaurant restaurant = new Restaurant();
        restaurant.setId(id)
                .setName(name)
                .setAddress(address)
                .setMenu(Collections.singletonList(menu));

        try {
            Restaurant restaurantUpdated = restaurantController.edit(restaurant, id);
            System.out.println("Restaurant updated successfully");
            System.out.println("Details: ");
            System.out.println("Name: " + restaurantUpdated.getName());
            System.out.println("Address: " + restaurantUpdated.getAddress());
            System.out.println("Menu: " + restaurantUpdated.getMenu());
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



//    public void updateRestaurant() {
//
//        System.out.println("Please enter the ID of the Restaurant you want to update:");
//        String id = scanner.nextLine();
//
//        System.out.println("Please enter updated Restaurant details:\n");
//
//        System.out.println("Name: ");
//        String name = scanner.nextLine();
//        System.out.println("Address: ");
//        String address = scanner.nextLine();
//        System.out.println("Menu: ");
//        String menu = scanner.nextLine();
//
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(id)
//                .setName(name)
//                .setAddress(address)
//                .setMenu(Collections.singletonList(menu));
//
//        try {
//            Restaurant restaurantUpdated = restaurantController.edit(restaurant,id);
//            System.out.println("Restaurant updated successfully");
//            System.out.println("Details: ");
//            System.out.println("Name: "+restaurantUpdated.getName());
//            System.out.println("Address: "+restaurantUpdated.getAddress());
//            System.out.println("Menu: "+restaurantUpdated.getMenu());
//
//        } catch (RestaurantNotFoundException e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//    }

//    public void updateCustomer() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please enter the ID of the Customer you want to Update:");
//        String id = scanner.nextLine();
//
//        System.out.println("Please update by entering the following updated customer details\n");
//
//        System.out.println("Enter Name:");
//        String name = scanner.nextLine();
//        System.out.println("Enter E-mail:");
//        String email = scanner.nextLine();
//        System.out.println("Enter Password:");
//        String password = scanner.nextLine();
//
//        Customer customer = new Customer();
//        customer.setId(id)
//                .setName(name)
//                .setEmail(email)
//                .setPassword(password);
//
//        try {
//            customerController.edit(customer, id);
//            System.out.println("Customer updated successfully.");
//            System.out.println("Updated Details:");
//            System.out.println("Id : " + id);
//            System.out.println("Name : " + customer.getName());
//            System.out.println("E-mail : " + customer.getEmail());
//            System.out.println("Password : " + customer.getPassword());
//        } catch (CustomerNotFoundException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }


    public void deleteRestaurant() {
        System.out.println("Please Enter the Restaurant ID you want to delete: ");
        String id = scanner.nextLine();

        try{
            restaurantController.delete(id);
            System.out.println("Restaurant with the ID: "+ id +" deleted successfully");
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

}
