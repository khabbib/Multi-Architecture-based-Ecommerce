package com.example.CartsService.service;


import com.example.CartsService.model.Cart;
import com.example.CartsService.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CompletableFuture<List<Cart>> getAvailableCarts() {
        return cartRepository.getAvailableCarts();
    }

    public CompletableFuture<String> createNewCart(Cart cart) {
        return cartRepository.createNewCart(cart);
    }

    public CompletableFuture<Cart> getCartById(String id) {
        return cartRepository.getCartById(id);
    }

    public ResponseEntity<String> addItemToCart(String cartId, String productId) {
        return cartRepository.addItemToCart(cartId, productId);
    }

    public CompletableFuture<String> deleteExistingCart(String id) {
        return cartRepository.deleteExistingCart(id);
    }

    public CompletableFuture<Cart> removeItemFromCart(String cartId, String productId) {
        return cartRepository.removeItemFromCart(cartId, productId);
    }
}
