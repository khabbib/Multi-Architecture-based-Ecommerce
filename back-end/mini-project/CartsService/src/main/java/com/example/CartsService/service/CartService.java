package com.example.CartsService.service;


import com.example.CartsService.model.Cart;
import com.example.CartsService.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CompletableFuture<ArrayList<Cart>> getAvailableCarts() {
        return cartRepository.getAvailableCarts();
    }

    public CompletableFuture<String> createNewCart(Cart cart) {
        return cartRepository.createNewCart(cart);
    }

    public CompletableFuture<Cart> getCartById(String id) {
        return cartRepository.getCartById(id);
    }

    public CompletableFuture<Cart> updateExistingCart(String id, Cart cart) {
        return cartRepository.updateExistingCart(id, cart);
    }

    public CompletableFuture<String> deleteExistingCart(String id) {
        return cartRepository.deleteExistingCart(id);
    }
}
