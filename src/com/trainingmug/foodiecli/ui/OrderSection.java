package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.OrderController;
import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.exceptions.OrderExistsException;
import com.trainingmug.foodiecli.exceptions.OrderNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Order;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.service.DishService;
import com.trainingmug.foodiecli.service.RestaurantService;
import com.trainingmug.foodiecli.util.Factory;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OrderSection {
    private final OrderController orderController;

    public OrderSection() {
        this.orderController = Factory.getOrderController();
    }

    public void placeNewOrder() throws DishNotFoundException {

        Customer loggedInCustomer = null;
        Restaurant restaurant = null;
        List<Dish> dishList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(System.in);
            CustomerService customerService = Factory.getCustomerService();
            RestaurantService restaurantService = Factory.getRestaurantService();
            DishService dishService = Factory.getDishService();
            loggedInCustomer = customerService.getCurrentLogin();
            if(loggedInCustomer != null )
                System.out.println("Hello , " + loggedInCustomer.getName());
            while (loggedInCustomer == null) {
                System.out.println("Please login to place an order");
                new CustomerSection().loginCustomer();
                loggedInCustomer = customerService.getCurrentLogin();
            }

            System.out.println("Enter Order Id :");
            String id = scanner.nextLine();

            while (restaurant == null) {
                new RestaurantSection().viewRestaurants();

                System.out.println("Choose the Restaurant Id (Ex: R08 )");
                String restaurantId = scanner.nextLine();
                restaurant = restaurantService.getRestaurantById(restaurantId);
            }
            char addMoreItems = 'Y';
            while (addMoreItems == 'Y') {
                new RestaurantSection().displayMenuItems(restaurant.getId());

                System.out.println("Enter the Dish Id (Ex : D001 )");
                String dishId = scanner.nextLine();
                Dish selectedDish = dishService.getDishById(dishId);
                dishList.add(selectedDish);
                System.out.println("One Dish is added successfully : " + selectedDish.getName());
                System.out.println("Do you want to add more dishes (Y/N)");
                addMoreItems = scanner.nextLine().charAt(0);
            }


            double orderPrice = calculateOrderTotalPrice(dishList);
            LocalDate orderDate = LocalDate.now();



            Order order = new Order();
            order.setId(id)
                    .setCustomer(loggedInCustomer)
                    .setRestaurant(restaurant)
                    .setDishes(dishList)
                    .setTotalPrice(orderPrice)
                    .setOrderDate(orderDate);

            Order placedOrder = orderController.save(order);
            if(placedOrder != null)
                System.out.println("Order Placed Successfully with the following details");

            displayOrderDetails(placedOrder);

        } catch (RestaurantNotFoundException | OrderExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculateOrderTotalPrice(List<Dish> dishList) {
        return dishList.stream().mapToDouble(Dish::getPrice).sum();
    }

    void viewALlOrders() {
        List<Order> ordersList = this.orderController.getAllOrders();

        System.out.printf("Id", "Customer Name", "Restaurant Name", "Items", "Order Date", "Price");


        ordersList.forEach(order -> {
            String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
            System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames, order.getOrderDate(), order.getTotalPrice());
        });
        System.out.println("\n\n");
    }

    void getOrderById() throws RestaurantNotFoundException, DishNotFoundException {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Order\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Order order = orderController.getOrderById(id);
            displayOrderDetails(order);
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
            Dashboard dashboard = new Dashboard();
            dashboard.orderSection();
        }
    }

    private void displayOrderDetails(Order order) {
        String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items","Order Date","Price");

        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames,order.getOrderDate(),String.format("$%.2f", order.getTotalPrice()));


    }



}
