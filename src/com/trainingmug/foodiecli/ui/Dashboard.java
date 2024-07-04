package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.exceptions.DishNotFoundException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;

import java.util.Scanner;

public class Dashboard  {

    CustomerSection customerSection = new CustomerSection();
    RestaurantSection restaurantSection = new RestaurantSection();
    DishSection dishSection = new DishSection();
    OrderSection orderSection = new OrderSection();
    Scanner scanner = new Scanner(System.in);

    public void displayDashboard() throws RestaurantNotFoundException, DishNotFoundException {

        while (true) {

            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO FOODIE APP DASHBOARD                   ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Customers Section");
            System.out.println("2. Restaurants Section");
            System.out.println("3. Dish Section");
            System.out.println("4. Order Section");
            System.out.println("5. Exit");

            System.out.println("Please enter your choice (1-5)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> customerSection();
                case 2 -> restaurantSection();
                case 3 -> dishesSection();
                case 4 -> orderSection();
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-5)");
            }
        }
    }


    private void customerSection() throws RestaurantNotFoundException, DishNotFoundException {

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO Customers Section                      ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. View All Customers");
            System.out.println("4. Search Customer");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Return To Dashboard");
            System.out.println("Please enter your choice (1-7)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> customerSection.signUpCustomer();
                case 2 -> customerSection.loginCustomer();
                case 3 -> customerSection.viewCustomers();
                case 4 -> customerSection.getCustomerById();
                case 5 -> customerSection.updateCustomer();
                case 6 -> customerSection.deleteCustomer();
                case 7 -> displayDashboard();
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");
            }
        }
    }

    private void restaurantSection() throws RestaurantNotFoundException, DishNotFoundException {

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO Restaurant Section                     ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Add Restaurant");
            System.out.println("2. View All Restaurants");
            System.out.println("3. Search Restaurants");
            System.out.println("4. Update Restaurants");
            System.out.println("5. Delete Restaurants");
            System.out.println("6. Return To Dashboard");
            System.out.println("Please enter your choice (1-6)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> restaurantSection.addRestaurant();
                case 2 -> restaurantSection.viewRestaurants();
                case 3 -> restaurantSection.searchRestaurant();
                case 4 -> restaurantSection.updateRestaurant();
                case 5 -> restaurantSection.deleteRestaurant();
                case 6 -> displayDashboard();
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-6)");
            }
        }
    }

    private void dishesSection() throws RestaurantNotFoundException, DishNotFoundException {

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO Dishes Section                     ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Add Dish");
            System.out.println("2. View All Dishes");
            System.out.println("3. Search Dish");
            System.out.println("4. Update Dish");
            System.out.println("5. Delete Dish");
            System.out.println("6. Return To Dashboard");
            System.out.println("Please enter your choice (1-6)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> dishSection.addDish();
                case 2 -> dishSection.viewDish();
                case 3 -> dishSection.searchDish();
                case 4 -> dishSection.updateDish();
                case 5 -> dishSection.deleteDish();
                case 6 -> displayDashboard();
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-6)");
            }
        }
    }

    void orderSection() throws RestaurantNotFoundException, DishNotFoundException {

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("                WELCOME TO Order Section                     ");
            System.out.println("------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Place an Order");
            System.out.println("2. Search Order");
            System.out.println("3. View All Orders");
            System.out.println("4. Return to Dashboard");
            System.out.println("Please enter your choice (1-4)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> orderSection.placeNewOrder();
                case 2 -> orderSection.getOrderById();
                case 3 -> orderSection.viewALlOrders();
                case 4 -> displayDashboard();
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-6)");
            }
        }
    }


}
