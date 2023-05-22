package com.example.SearchService.repository;

import com.example.ProductService.model.Product;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SearchRepository {

    public SearchRepository() {
        System.out.println("SearchRepository created");
    }

    /**
     * Search for products by name.
     * @param query The search query.
     * @return A CompletableFuture that will complete with the list of matching products.
     */
    public CompletableFuture<List<Product>> searchProducts(@RequestParam String query) {
        System.out.println("creating future...");
        CompletableFuture<List<Product>> future = new CompletableFuture<>();
        System.out.println("future created");
        System.out.println("getting reference...");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("product");
        System.out.println("reference gotten");
        System.out.println("creating listener...");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("Searching for products that start with " + query + "...");
                // create a list to hold the products
                List<Product> productList = new ArrayList<>();
                // loop through the children of the snapshot, which represent the individual products
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert the DataSnapshot to a Product object and complete the future with the product
                    Product product = dataSnapshot.getValue(Product.class);
                    if(product.getpName().contains(query)){
                        productList.add(product);
                    }
                }
                System.out.println("end of for loop");
                // complete the future with the list of products
                future.complete(productList);
                System.out.println("Successfully retrieved " + productList.size() + " products.");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("on cancelled");
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
}
