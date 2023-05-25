package com.example.CartsService.repository;

import com.example.CartsService.model.Cart;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class CartRepository {

    public CartRepository(){
        System.out.println("CartRepository created");
    }

    /**
     * Done and tested.
     * Get all carts from the database.
     * @return a list of carts.
     */
    public CompletableFuture<List<Cart>> getAvailableCarts() {
        CompletableFuture<List<Cart>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("cart");

        System.out.println("Entering on data change method!!");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the products
                List<Cart> cartList = new ArrayList<>();

                if(snapshot.exists()){
                    System.out.println("Datasnapshot exist " + snapshot.toString());
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        System.out.println("Retriving datasnapshot to cart.");
                        // Convert the DataSnapshot to a Product object and complete the future with the cart
                        Cart retrievedCart = dataSnapshot.getValue(Cart.class);
                        // add the cart to the list
                        cartList.add(retrievedCart);
                        System.out.println("Retrived a cart from db..");
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

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart");
        DatabaseReference newCartReference = databaseReference.push();
        newCartReference.setValueAsync(cart);
        String cartId = newCartReference.getKey();
        future.complete(cartId);
        return future;

    }

    /**
     * ToDo: Test method with postman.
     * Gets a cart from the database using the specific cart id.
     * @param cartId the id of the cart
     * @return the cart to be returned
     */
    public CompletableFuture<Cart> getCartById(String cartId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart").child(String.valueOf(cartId));
        CompletableFuture<Cart> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Convert the DataSnapshot to a Cart object and complete the future with the product
                    Cart retrievedCart = dataSnapshot.getValue(Cart.class);
                    future.complete(retrievedCart);
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

    //Lägg till en ny produkt i kundvagnen.
    //ToDo: Implementera
    public ResponseEntity<String> addItemToCart(String cartId, String productId) {
        ///cart/gadhf34g1j234gf/products
        //cart/{cartId}/products

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart/" + cartId + "/products");
        DatabaseReference newCartReference = databaseReference.push();
        //Kolla först så att produkten är tillgänglig. Använd WebConfig för att kontakta Product-Service
        //Hämta produkterna som en array och lägg till produkten som ska läggas till.
        //Returnera sedan carten.

        return ResponseEntity.ok().body(productId);

        /*
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("product");
        DatabaseReference newProductReference = databaseReference.push();
        newProductReference.setValueAsync(product);
        String productId = newProductReference.getKey();
        return ResponseEntity.ok().body(productId);
         */
    }

    public CompletableFuture<String> deleteExistingCart(String id) {
        CompletableFuture<String> future = new CompletableFuture<>();

        return future;
    }

    public CompletableFuture<Cart> removeItemFromCart(String cartId, String productId) {
        CompletableFuture<Cart> future = new CompletableFuture<>();

        return future;
    }
}
