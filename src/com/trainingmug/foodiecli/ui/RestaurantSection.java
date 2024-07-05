package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.RestaurantService;
import com.trainingmug.foodiecli.util.Factory;
import com.trainingmug.foodiecli.util.Validate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantSection {

    Validate validate = new Validate();

    static RestaurantController restaurantController = Factory.getRestaurantController();
    static Scanner scanner = new Scanner(System.in);

    public void addRestaurant(){

        System.out.println("Add a Restaurant entering the following details:\n");
        System.out.println("Enter ID:");
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
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        Map<String, String> addressValidation = validate.validateName(name);
        if (!addressValidation.get("Name").equals("1")) {
            System.out.println(addressValidation.get("Name"));
            return;
        }
        System.out.println("Enter Menu:");
        String menu = scanner.nextLine();
        Map<String, String> menuValidation = validate.validateMenu(menu);
        if (!menuValidation.get("Name").equals("1")) {
            System.out.println(menuValidation.get("Name"));
            return;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(id)
                .setName(name)
                .setAddress(address)
                .setMenu(Collections.singletonList(menu));

        try {
            Restaurant restaurant1 = restaurantController.save(restaurant);
            displayMenuHeader("Restaurant Details");
            System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant1.getId(), restaurant1.getName(), restaurant1.getAddress(), String.join(":", restaurant1.getMenu()));
            System.out.println("\n\n");
        } catch (RestaurantAlreadyExistsException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void viewRestaurants() {

        List<Restaurant> restaurantList = restaurantController.getAllRestaurants();
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
        });
        System.out.println("\n\n");
    }

    public void searchRestaurant() {

        System.out.println("Please enter the ID of the Restaurant you want to search:");
        String id = scanner.nextLine();

        try{
            Restaurant restaurant = restaurantController.getRestaurantById(id);
            displayMenuHeader("Restaurant Details");
            System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
            System.out.println("\n\n");
        } catch (RestaurantNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateRestaurant() {
        System.out.println("Please enter the ID of the Restaurant you want to update:");
        String id = scanner.nextLine();
        Map<String, String> idValidation = validate.validateId(id);
        if (!idValidation.get("Id").equals("1")) {
            System.out.println(idValidation.get("Id"));
            return;
        }

        System.out.println("Please enter updated Restaurant details:\n");

        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Map<String, String> nameValidation = validate.validateName(name);
        if (!nameValidation.get("Name").equals("1")) {
            System.out.println(nameValidation.get("Name"));
            return;
        }
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        Map<String, String> addressValidation = validate.validateName(name);
        if (!addressValidation.get("Name").equals("1")) {
            System.out.println(addressValidation.get("Name"));
            return;
        }
        System.out.println("Enter Menu:");
        String menu = scanner.nextLine();
        Map<String, String> menuValidation = validate.validateMenu(menu);
        if (!menuValidation.get("Name").equals("1")) {
            System.out.println(menuValidation.get("Name"));
            return;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(id)
                .setName(name)
                .setAddress(address)
                .setMenu(Collections.singletonList(menu));

        try {
            Restaurant restaurant1 = restaurantController.edit(restaurant, id);
            displayMenuHeader("Restaurant Details");
            System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant1.getId(), restaurant1.getName(), restaurant1.getAddress(), String.join(":", restaurant1.getMenu()));
            System.out.println("\n\n");
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayMenuItems(String restaurantId) throws RestaurantNotFoundException, DishNotFoundException {

        displayMenuHeader("Dishes Menu Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        RestaurantService restaurantService = Factory.getRestaurantService();
        List<Dish> dishItems = restaurantService.getDishItems(restaurantId);
        for(Dish dish : dishItems){
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        }
        System.out.println("\n\n");
    }

    public void deleteRestaurant() {
        System.out.println("Please Enter the Restaurant ID you want to delete: ");
        String id = scanner.nextLine();

        try{
            restaurantController.delete(id);
            System.out.println("Restaurant with the ID: "+ id +" deleted successfully");
            System.out.println("\n\n");
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }

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
