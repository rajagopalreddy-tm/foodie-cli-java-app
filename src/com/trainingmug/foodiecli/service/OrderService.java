package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.OrderExistsException;
import com.trainingmug.foodiecli.exceptions.OrderNotFoundException;
import com.trainingmug.foodiecli.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order save(Order order) throws OrderExistsException;
    Order getOrderById(String id) throws OrderNotFoundException;

}
