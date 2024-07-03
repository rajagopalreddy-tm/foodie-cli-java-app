package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.DishController;
import com.trainingmug.foodiecli.exceptions.DishAlreadyExistsException;
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
    }

    public void updateDish() {
    }

    public void deleteDish() {
    }
}
