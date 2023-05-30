package com.example.OrderService.controller;

import com.example.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.OrderService.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // Get all orders
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ArrayList<Order>> getAvailableOrders() {
        CompletableFuture<ArrayList<Order>> products = orderService.getAllOrders();
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
        CompletableFuture<Order> order = orderService.getOrderById(id);
        return order.toString();
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable("id") String id) {
        try {
            return orderService.getOrdersByCustomerId(id).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
