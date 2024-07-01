package com.trainingmug.foodiecli.java;

import java.util.Objects;

public class Dish {

    /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      description
    double                      price
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
    private String description;
    private double price;

    //no-arg constructor
    public Dish() {
    }

    //Getters and Setter methods
    public String getId() {
        return id;
    }
    public Dish setId(String id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public Dish setName(String name) {
        this.name = name;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public Dish setDescription(String description) {
        this.description = description;
        return this;
    }
    public double getPrice() {
        return price;
    }
    public Dish setPrice(double price) {
        this.price = price;
        return this;
    }

    //equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(price, dish.price) == 0 && Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(description, dish.description);
    }

    //hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    //toString() method
    @Override
    public String toString() {
        return "Dish{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
