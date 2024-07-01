package com.trainingmug.foodiecli.java;

import java.util.List;
import java.util.Objects;

public class Customer {

    /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      email
    String                      password
    List<Dish>                  orderHistory
    /
    /
    All the fields should be private
    Create only no-arg constructor
    Create Getters and Setter methods
    Override hashCode() and equals() methods
    Override toString() methods
    */

    private String id;
    private String name;
    private String email;
    private String password;
//    private List<Order>  orderHistory;

    //no-arg constructor
    public Customer() {
    }

    //Getters and Setter methods
    public String getId() {
        return id;
    }
    public Customer setId(String id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public Customer setName(String name) {
        this.name = name;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }
//    public List<Order> getOrderHistory() {
//
//        this.orderHistory = orderHistory;
//        return (List<Order>) this;
//    }

    //equals() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    //hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    //toString() method
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
