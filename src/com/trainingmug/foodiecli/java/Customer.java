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
    private List<Order> orderHistory;

    public Customer() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(orderHistory, customer.orderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, orderHistory);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
