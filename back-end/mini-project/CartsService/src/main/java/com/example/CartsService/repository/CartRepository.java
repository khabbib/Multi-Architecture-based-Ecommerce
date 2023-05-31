package com.example.CartsService.repository;

import com.example.CartsService.model.Cart;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.fasterxml.jackson.core.io.NumberInput.parseDouble;

@Repository
public class CartRepository {

    public CartRepository(){
        System.out.println("CartRepository created");
    }

    public CompletableFuture<List<Cart>> getAvailableCarts() {
        CompletableFuture<List<Cart>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("cart");

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the products
                List<Cart> cartList = new ArrayList<>();

                if(snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                        // Convert the DataSnapshot to a Cart object and add the productlist to cart.
                        Cart retrievedCart = dataSnapshot.getValue(Cart.class);
                        // add the cart to the list
                        cartList.add(retrievedCart);
                    }
                }else{
                    System.out.println("Snapshot doesnt exist!");
                }

                // loop through the children of the snapshot, which represent the individual carts


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
        System.out.println("Creating new cart..." + cart.toString());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart");
        DatabaseReference newCartReference = databaseReference.push();
        newCartReference.setValueAsync(cart);
        String cartId = newCartReference.getKey();
        future.complete(cartId);
        return future;

    }

    public CompletableFuture<Cart> getCartById(String cartId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart").child(String.valueOf(cartId));
        CompletableFuture<Cart> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    System.out.println("Datasnapshot: " + dataSnapshot.toString());
                    Cart retrievedCart = dataSnapshot.getValue(Cart.class);
                    future.complete(retrievedCart);
                    System.out.println("Cart with id " + cartId + " found in database!");
                } else {
                    // If the cart is not found, complete the future exceptionally with a not found exception
                    System.out.println("Cart with id " + cartId + " not found in database!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public ResponseEntity<String> addItemToCart(String cartId, String productId) {
        CompletableFuture<Cart> cart = getCartById(cartId);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart").child(cartId).child("productList");;

        try{
            Map<String, String> map = cart.get().getProductList();

            if(map != null){
                if(map.containsKey(productId)){
                    int amount = Integer.parseInt(map.get(productId));
                    amount++;
                    map.put(productId, Integer.toString(amount));
                }else{
                    map.put(productId, "1");
                }
                databaseReference.setValueAsync(map);

            }else{
                Map<String, String> newProductList = new HashMap<>();
                newProductList.put(productId, "1");
                databaseReference.setValueAsync(newProductList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().body("Added to productlist: " + productId);
    }

    public ResponseEntity<String> deleteExistingCart(String cartId) {
        try {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart").child(cartId);
            databaseReference.removeValueAsync().get();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<String> removeItemFromCart(String cartId, String productId) {
        CompletableFuture<Cart> cart = getCartById(cartId);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart").child(cartId).child("productList");

        try{
            Map<String, String> map = cart.get().getProductList();

            if(map != null){
                if(map.containsKey(productId)){
                    int amount = Integer.parseInt(map.get(productId));
                    if(amount > 1){
                        amount--;
                        map.put(productId, Integer.toString(amount));
                    }else{
                        map.remove(productId);
                    }
                    databaseReference.setValueAsync(map);
                }else{
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().body("Removed item: " + productId);
    }
}
