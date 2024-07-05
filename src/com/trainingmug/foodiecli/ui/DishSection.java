package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.DishController;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.util.Factory;
import com.trainingmug.foodiecli.util.Validate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DishSection {

    DishController dishController = Factory.getDishController();
    Validate validate = new Validate();

    Scanner scanner = new Scanner(System.in);

    public void addDish() {
        System.out.println("Add a Dish entering the following details:\n");

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

        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        Map<String, String> descriptionValidation = validate.validateDescription(description);
        if (!descriptionValidation.get("Description").equals("1")){
            System.out.println(descriptionValidation.get("Description"));
        }

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        Map<String, String> priceValidation = validate.validatePrice(String.valueOf(price));
        if(!priceValidation.get("Price").equals("1")){
            System.out.println(priceValidation.get("Price"));
        }

        Dish dish = new Dish();
        dish.setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price);

        try{
            Dish dish1 = dishController.addDish(dish);
            displayMenuHeader("Dish Details");
            System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish1.getId(), dish1.getName(), dish1.getDescription(), String.format("$%.2f", dish1.getPrice()));
            System.out.println("\n\n");
        } catch (DishAlreadyExistsException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void viewDish() {

        List<Dish> dishesList = this.dishController.getAllDishes();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Dish Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice())));
        System.out.println("\n\n");
    }

    public void searchDish() {
        System.out.println("Please enter the ID of the Customer you want to search:");
        String id = scanner.nextLine();

        try {
            Dish dish =  dishController.getDishById(id);
            displayMenuHeader("Dish Details");
            System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
            System.out.println("\n\n");
        } catch (DishNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateDish() {
        System.out.println("Please enter the ID of the Restaurant you want to update:");
        String id = scanner.nextLine();

        System.out.println("Please enter updated Restaurant details:\n");

        System.out.println("Enter Name");
        String name = scanner.nextLine();
        Map<String, String> nameValidation = validate.validateName(name);
        if (!nameValidation.get("Name").equals("1")) {
            System.out.println(nameValidation.get("Name"));
            return;
        }

        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        Map<String, String> descriptionValidation = validate.validateDescription(description);
        if (!descriptionValidation.get("Description").equals("1")){
            System.out.println(descriptionValidation.get("Description"));
        }

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        Map<String, String> priceValidation = validate.validatePrice(String.valueOf(price));
        if(!priceValidation.get("Price").equals("1")){
            System.out.println(priceValidation.get("Price"));
        }

        Dish dish = new Dish();
        dish.setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price);

        try {
            Dish dish1 = dishController.edit(dish, id);
            displayMenuHeader("Dish Details");
            System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
            printDashLine();
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish1.getId(), dish1.getName(), dish1.getDescription(), String.format("$%.2f", dish1.getPrice()));
            System.out.println("\n\n");
        } catch (DishNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteDish() {
        System.out.println("Enter the ID of the Dish you want to delete \n");
        String id = scanner.nextLine();

        try{
            dishController.delete(id);
            System.out.println("Dish with ID: "+id+ " deleted !");
            System.out.println("\n\n");
        } catch (DishNotFoundException e) {
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