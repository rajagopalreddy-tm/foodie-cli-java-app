package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.OrderController;
import com.trainingmug.foodiecli.exceptions.*;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Dish;
import com.trainingmug.foodiecli.model.Order;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.service.DishService;
import com.trainingmug.foodiecli.service.RestaurantService;
import com.trainingmug.foodiecli.util.Factory;
import com.trainingmug.foodiecli.util.Validate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OrderSection {
    private final OrderController orderController;

    Validate validate = new Validate();

    public OrderSection() {
        this.orderController = Factory.getOrderController();
    }



    public void placeNewOrder() throws DishNotFoundException {

        Customer loggedInCustomer;
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
            Map<String, String> oIdValidation = validate.validateId(id);
            if (!oIdValidation.get("Id").equals("1")) {
                System.out.println(oIdValidation.get("Id"));
                return;
            }

            while (restaurant == null) {
                new RestaurantSection().viewRestaurants();
                printDashLine();
                System.out.println("Choose the Restaurant Id: ");
                String restaurantId = scanner.nextLine();
                Map<String, String> rIdValidation = validate.validateId(restaurantId);
                if (!rIdValidation.get("Id").equals("1")) {
                    System.out.println(rIdValidation.get("Id"));
                    return;
                }
                restaurant = restaurantService.getRestaurantById(restaurantId);
            }
            char addMoreItems = 'Y';
            while (addMoreItems == 'Y') {
                new RestaurantSection().displayMenuItems(restaurant.getId());
                printDashLine();
                System.out.println("Enter the Dish Id: ");
                String dishId = scanner.nextLine();
                Map<String, String> dIdValidation = validate.validateId(dishId);
                if (!dIdValidation.get("Id").equals("1")) {
                    System.out.println(dIdValidation.get("Id"));
                    return;
                }
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
        return dishList.stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }

    void viewALlOrders() {
        List<Order> ordersList = this.orderController.getAllOrders();
        displayMenuHeader("All Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items", "Order Date", "Price");
        printDashLine();


        ordersList.forEach(order -> {
            String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
            System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames, order.getOrderDate(), order.getTotalPrice());
        });
        System.out.println("\n\n");
    }

    void getOrderById() throws RestaurantNotFoundException, DishNotFoundException {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Order");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Map<String, String> IdValidation = validate.validateId(id);
            if (!IdValidation.get("Id").equals("1")) {
                System.out.println(IdValidation.get("Id"));
                return;
            }
            Order order = orderController.getOrderById(id);
            displayOrderDetails(order);
            System.out.println("\n\n");
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
            Dashboard dashboard = new Dashboard();
            dashboard.orderSection();
        }
    }

    private void displayOrderDetails(Order order) {
        displayMenuHeader("Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items", "Order Date", "Price");
        printDashLine();

        String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames, order.getOrderDate(), order.getTotalPrice());
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
