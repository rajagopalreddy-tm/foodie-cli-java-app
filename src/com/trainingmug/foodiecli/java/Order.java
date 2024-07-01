package com.trainingmug.foodiecli.java;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

     /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    Customer                    customer
    Restaurant                  restaurant
    List<Dish>                  dishes
    double                      totalPrice
    Date                        orderDate
    /
    /
    All the fields should be private
    Create only no-arg constructor
    Create Getters and Setter methods
    Override hashCode() and equals() methods
    Override toString() methods
    */

    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dish> dishes;
    private double totalPrice;
    private Date orderDate;

    //no-arg constructor
    public Order() {
    }

    //Getters and Setter methods
    public String getId() {
        return id;
    }
    public Order setId(String id) {
        this.id = id;
        return this;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
    public List<Dish> getDishes() {
        return dishes;
    }
    public Order setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        return this;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    //equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishes, order.dishes) && Objects.equals(orderDate, order.orderDate);
    }

    //hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, customer, restaurant, dishes, totalPrice, orderDate);
    }

    //toString() method
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", dishes=" + dishes +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }

}
