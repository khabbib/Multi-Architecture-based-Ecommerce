package com.example.ProductService.repository;

import com.example.ProductService.model.Product;
import com.example.util.FirebaseInitializer;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Repository
public class ProductRepository {
    public ProductRepository() throws IOException {
        System.out.println("ProductRepository created");
    }

    /**
     * Get all products as a list.
     * @return List<Product>
     */
    public CompletableFuture<List<Product>> getAllProducts() {
        CompletableFuture<List<Product>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("product");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the products
                List<Product> productList = new ArrayList<>();

                // loop through the children of the snapshot, which represent the individual products
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert the DataSnapshot to a Product object and complete the future with the product
                    Product retrievedProduct = dataSnapshot.getValue(Product.class);
                    // add the product to the list
                    productList.add(retrievedProduct);
                }

                // complete the future with the list of products
                future.complete(productList);
                System.out.println("Successfully retrieved " + productList.size() + " products.");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the operation is cancelled or fails, complete the future exceptionally
                future.completeExceptionally(error.toException());
                System.err.println("Error retrieving products: " + error.getMessage());
            }
        };

        // attach the listener to the reference and return the future
        ref.addValueEventListener(listener);
        System.out.println("Fetching products...");
        return future;
    }


    /**
     * Get product by ID.
     * @return Product
     */
    public CompletableFuture<Product> getProductById(String productId) throws ExecutionException, InterruptedException {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("product").child(String.valueOf(productId));
        CompletableFuture<Product> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Convert the DataSnapshot to a Product object and complete the future with the product
                    Product retrievedProduct = dataSnapshot.getValue(Product.class);
                    future.complete(retrievedProduct);
                } else {
                    // If the product is not found, complete the future exceptionally with a not found exception
                    System.out.println("Product with id " + productId + " not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    /**
     * Create a product.
     * @param product
     * @return
     */
    public ResponseEntity<String> createProduct(Product product) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("product");
        DatabaseReference newProductReference = databaseReference.push();
        newProductReference.setValueAsync(product);
        String productId = newProductReference.getKey();
        return ResponseEntity.ok().body(productId);
    }

    /**
     * Deletes the product with proposed ID.
     * @param id
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> deleteProduct(String id) {
        try {
            DatabaseReference productRef = FirebaseDatabase.getInstance().getReference("product").child(id);
            productRef.removeValueAsync().get();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update a product.
     * @param id
     * @param product
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> updateProduct(String id, Product product) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("product/" + id);
        ref.setValueAsync(product);
        return ResponseEntity.ok("Product updated successfully");
    }

    public void deleteAllProducts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("product");
        ref.removeValueAsync();
    }

}
