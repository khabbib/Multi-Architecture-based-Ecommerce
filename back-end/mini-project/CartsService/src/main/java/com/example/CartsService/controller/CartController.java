package com.example.CartsService.controller;


import com.example.CartsService.model.Cart;
import com.example.CartsService.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/") //Get all carts
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ArrayList<Cart>> getAvailableCarts(){
        return cartService.getAvailableCarts();
    }

    @GetMapping("/{id}") //Get specific cart
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<Cart> getCartById(@PathVariable("id") String id){
        return cartService.getCartById(id);
    }

    @PostMapping("/create") //Create a new cart
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createNewCart(@RequestBody Cart cart){
        return cartService.createNewCart(cart);
    }

    @PutMapping("/{id}") //Update a specific cart
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Cart> updateExistingCart(@RequestHeader String id, @RequestBody Cart cart){
        return cartService.updateExistingCart(id, cart);
    }

    @DeleteMapping("/{id}") //Delete a specific cart
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<String> deleteExistingCart(@PathVariable("id") String id){
        return cartService.deleteExistingCart(id);
    }
}
