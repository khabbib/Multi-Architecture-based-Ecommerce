package com.example.OrderService.controller;

import com.example.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.OrderService.model.Order;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // Get all orders
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Order> getAvailableOrders() {
        ArrayList<Order> products = orderService.getAllOrders();
        return products;
    }


    // Add order
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return order.toString();
    }

    // Get order by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getOrderById(@PathVariable("id") String id) {
        Order order = orderService.getOrderById(id);
        return order.toString();
    }

}
