package com.example.SearchService.repository;


import com.example.ProductService.model.Product;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SearchRepository {

    public SearchRepository () throws IOException {
        System.out.println("Search repository created!");
    }


    /**
     * Search for products by name.
     * @param query The search query.
     * @return A CompletableFuture that will complete with the list of matching products.
     */
    public CompletableFuture<List<Product>> searchProducts(String query) {
        // A CompletableFuture that will be completed when the Firebase query completes.
        CompletableFuture<List<Product>> future = new CompletableFuture<>();

        // Get a reference to the Firebase database.
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("product");

        // Create a Firebase query that will find products with a name that starts with the query.
        // The "\uf8ff" is a high Unicode character that ensures the query includes all names that start with the search term.
        // This effectively makes the query a "starts with" query.
        Query searchQuery = ref.orderByChild("name").startAt(query).endAt(query + "\uf8ff");

        // Add a listener to the query. This will be called when the data is available.
        searchQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Create a list to hold the products that match the search query.
                List<Product> productList = new ArrayList<>();

                // Loop through the results of the query.
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert each result into a Product object.
                    Product product = dataSnapshot.getValue(Product.class);
                    // Add the product to the list.
                    productList.add(product);
                }

                // Complete the future with the list of products.
                // This allows the method that called searchProducts to retrieve the results.
                future.complete(productList);
                for (Product product : productList) {
                    System.out.println("Found product: " + product.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // If the query fails, complete the future exceptionally.
                // This lets the method that called searchProducts know that something went wrong.
                future.completeExceptionally(error.toException());
            }
        });

        // Return the future. The method that called searchProducts can use this to retrieve the results once they're available.
        return future;
    }
}
