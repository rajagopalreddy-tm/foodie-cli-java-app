package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.DishController;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.util.Factory;

import java.util.List;
import java.util.Scanner;

public class DishSection {

    DishController dishController = Factory.getDishController();

    Scanner scanner = new Scanner(System.in);

    public void addDish() {
        System.out.println("Add a Dish entering the following details:\n");
        System.out.println("ID:");
        String id = scanner.nextLine();
        System.out.println(":Name: ");
        String name = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Price: ");
        double price = scanner.nextDouble();

        Dish dish = new Dish();
        dish.setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price);

        try{
            Dish newDish = dishController.addDish(dish);
            System.out.println("New Dish added successfully !");
            System.out.println("ID: " + newDish.getId());
            System.out.println("Name: " + newDish.getName());
            System.out.println("Description: " + newDish.getDescription());
            System.out.println("Price: " + newDish.getPrice());
        } catch (DishAlreadyExistsException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void viewDish() {
        System.out.println("All Dishes : ");
        System.out.println("-----------------------");

        List<Dish> allDishes = dishController.getAllDishes();
        for (Dish dish:allDishes) {
            System.out.println("ID: "+dish.getId());
            System.out.println("Name: "+dish.getName());
            System.out.println("Description: "+dish.getDescription());
            System.out.println("Price: "+dish.getPrice());
            System.out.println("------------------------");
        }

    }

    public void searchDish() {
        System.out.println("Please enter the ID of the Customer you want to search:");
        String id = scanner.nextLine();

        try {
            Dish dish =  dishController.getDishById(id);
            System.out.println("Dish Details:");
            System.out.println("ID: " + dish.getId());
            System.out.println("Name: " + dish.getName());
            System.out.println("Description: " + dish.getDescription());
            System.out.println("Price: " + dish.getPrice());
        } catch (DishNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateDish() {
        System.out.println("Please enter the ID of the Restaurant you want to update:");
        String id = scanner.nextLine();

        System.out.println("Please enter updated Restaurant details:\n");

        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Price: ");
        double price = scanner.nextDouble();

        Dish dish = new Dish();
        dish.setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price);

        try {
            Dish updateDish = dishController.edit(dish, id);
            System.out.println("Restaurant updated successfully");
            System.out.println("Details: ");
            System.out.println("Name: " + updateDish.getName());
            System.out.println("Description: " + updateDish.getDescription());
            System.out.println("Price: " + updateDish.getPrice());
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
        } catch (DishNotFoundException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }


}