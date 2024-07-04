package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.util.Factory;

import java.util.Scanner;

public class OrderSection {

    RestaurantSection restaurantSection = new RestaurantSection();
    Scanner scanner  = new Scanner(System.in);


    public void placeNewOrder() {
        restaurantSection.viewRestaurants();
        System.out.println("Select a Restaurant by entering the restaurant ID: ");
        String restaurantId = scanner.nextLine();

    }

    public void getOrderById() {
    }

    public void viewALlOrders() {
    }
}
