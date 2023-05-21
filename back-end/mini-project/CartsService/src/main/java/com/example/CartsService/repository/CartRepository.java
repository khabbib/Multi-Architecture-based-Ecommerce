package com.example.CartsService.repository;

import com.example.CartsService.model.Cart;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Repository
public class CartRepository {

    public CartRepository(){
        System.out.println("CartRepository created");
    }

    public CompletableFuture<ArrayList<Cart>> getAvailableCarts() {
        CompletableFuture<ArrayList<Cart>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("cart");

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the products
                ArrayList<Cart> cartList = new ArrayList<>();

                // loop through the children of the snapshot, which represent the individual carts
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert the DataSnapshot to a Product object and complete the future with the cart
                    Cart retrievedCart = dataSnapshot.getValue(Cart.class);
                    // add the cart to the list
                    cartList.add(retrievedCart);
                }

                // complete the future with the list of carts
                future.complete(cartList);
                System.out.println("Successfully retrieved " + cartList.size() + " carts.");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the operation is cancelled or fails, complete the future exceptionally
                future.completeExceptionally(error.toException());
                System.err.println("Error retrieving carts: " + error.getMessage());
            }
        };

        // attach the listener to the reference and return the future
        ref.addValueEventListener(listener);
        System.out.println("Fetching carts...");
        return future;
    }

    public CompletableFuture<String> createNewCart(Cart cart) {
        CompletableFuture<String> future = new CompletableFuture<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart");
        DatabaseReference newCartReference = databaseReference.push();
        newCartReference.setValueAsync(cart);
        String cartId = newCartReference.getKey();
        future.complete(cartId);
        return future;

    }

    public CompletableFuture<Cart> getCartById(String id) {
        CompletableFuture<Cart> future = new CompletableFuture<>();

        return future;
    }

    public CompletableFuture<Cart> updateExistingCart(String id, Cart cart) {
        CompletableFuture<Cart> future = new CompletableFuture<>();

        return future;
    }

    public CompletableFuture<String> deleteExistingCart(String id) {
        CompletableFuture<String> future = new CompletableFuture<>();

        return future;
    }
}
