package com.trainingmug.foodiecli.java;

import java.util.List;
import java.util.Objects;

public class Restaurant {

    /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      address
    List<Dish>                  menu
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
    private String address;
    private List<Dish> menu;

    //no-arg constructor
    public Restaurant() {
    }

    //Getters and Setter methods
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Dish> getMenu() {
        return menu;
    }
    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    //equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(menu, that.menu);
    }

    //hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, menu);
    }

    //toString() method
    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }

}
