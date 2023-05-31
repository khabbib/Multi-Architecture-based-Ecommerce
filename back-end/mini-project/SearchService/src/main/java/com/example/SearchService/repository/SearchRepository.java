package com.example.SearchService.repository;


import com.example.ProductService.model.Product;
import com.example.util.FirebaseInitializer;
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
        FirebaseInitializer.initializeFireBase("product");
        System.out.println("Search repository created.");
        System.out.println("Database initialized");
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
        // To lower and upper case check
        Query searchQuery = ref.orderByChild("pName").startAt(query).endAt(query + "\uf8ff");

        // Add a listener to the query. This will be called when the data is available.
        searchQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Create a list to hold the products that match the search query.
                List<Product> productList = new ArrayList<>();

                // Loop through the results of the query.
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert each result into a Product object.
                    String pId = dataSnapshot.child("pId").getValue(String.class);
                    String pName = dataSnapshot.child("pName").getValue(String.class);
                    String pType = dataSnapshot.child("pType").getValue(String.class);
                    String pColor = dataSnapshot.child("pColor").getValue(String.class);
                    String pCondition = dataSnapshot.child("pCondition").getValue(String.class);
                    double pPrice = dataSnapshot.child("pPrice").getValue(double.class);
                    double pQuantity = dataSnapshot.child("pQuantity").getValue(double.class);
                    String pOwner = dataSnapshot.child("pOwner").getValue(String.class);
                    Product product = new Product(pId, pName, pType, pColor, pCondition, pPrice, pQuantity, pOwner);
                    // Add the product to the list.
                    System.out.println("Product: " + product.toString());
                    productList.add(product);
                }

                // Complete the future with the list of products.
                // This allows the method that called searchProducts to retrieve the results.
                future.complete(productList);
                System.out.println("Successfully retrieved " + productList.size() + " products.");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // If the query fails, complete the future exceptionally.
                // This lets the method that called searchProducts know that something went wrong.
                future.completeExceptionally(error.toException());
                System.err.println("Error retrieving products: " + error.getMessage());
            }
        });


        // Return the future. The method that called searchProducts can use this to retrieve the results once they're available.
        System.out.println("Returning future" + future.toString());
        return future;
    }
}
