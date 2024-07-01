package com.trainingmug.foodiecli.util;

import com.trainingmug.foodiecli.java.Customer;
import com.trainingmug.foodiecli.java.Dish;
import com.trainingmug.foodiecli.java.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

//    private List<Dish> dishList;
//    private List<Customer> customerList;

    //Read Dish Csv
    public List<Dish> readDishListFromCsv() {
        String DISH_CSV_PATH = "C:\\SPRING_BOOT\\foodie-cli-java-app\\data\\dishes.csv";
        String line;
        List<Dish> dishList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DISH_CSV_PATH))){
            String splitCsvBy= ",";
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String [] data  = line.split(splitCsvBy);
                Dish dish = new Dish();
                dish.setId(data[0])
                        .setName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishList.add(dish);
            }
//            this.dishList = dishList;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("issue in reading csv file from the  path :" + DISH_CSV_PATH);
            System.exit(0);
        }
        return dishList;
    }

    //Read Customer Csv
    public List<Customer> readCustomerListFromCsv(){
        String CUSTOMER_CSV_PATH = "C:\\SPRING_BOOT\\foodie-cli-java-app\\data\\customers.csv";
        String line;
        List<Customer> customersList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(CUSTOMER_CSV_PATH))){
            String splitCsvBy = ",";
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine())!= null){
                String [] data = line.split(splitCsvBy);
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }
//            this.customerList = customersList;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("issue in reading csv file from the  path :" + CUSTOMER_CSV_PATH);
            System.exit(0);
        }
        return customersList;
    }

    //Read Restaurant Csv
    public List<Restaurant> readRestaurantListFromCsv(){
        String RESTAURANT_CSV_PATH = "C:\\SPRING_BOOT\\foodie-cli-java-app\\data\\restaurants.csv";
        String line;
        List<Restaurant> restaurantList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RESTAURANT_CSV_PATH))) {
            String splitCsvBy = ",";
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(splitCsvBy);
                if (data.length >= 4) { // Ensure at least 4 elements (0 to 3)
                    Restaurant restaurant = new Restaurant();
                    restaurant.setId(data[0])
                            .setName(data[1])
                            .setAddress(data[2])
                            .setMenu(Arrays.asList(data[3].split(":")));
                    restaurantList.add(restaurant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issue in reading CSV file from the path: " + RESTAURANT_CSV_PATH);
            System.exit(0);
        }
        return restaurantList;
    }

}
