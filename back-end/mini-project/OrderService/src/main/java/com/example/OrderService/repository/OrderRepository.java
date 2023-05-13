package com.example.OrderService.repository;

import com.example.OrderService.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OrderRepository {
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> findAll() {
        return orders;
    }

    public Order findById(String id) {
        Order order = orders.stream().filter(ord -> ord.getOrderId().equals(id)).findFirst().orElse(null);
        return order;
    }

    public void save(Order order) {
        orders.add(order);
    }
}
