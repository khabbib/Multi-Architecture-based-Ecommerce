package com.example.shopeepy.service;

import com.example.shopeepy.model.Product;
import com.google.api.gax.rpc.NotFoundException;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductService {


    public ProductService() {
        System.out.println("ProductService created");
    }

    public CompletableFuture<Product> getProductById(Long productId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("product").child(String.valueOf(productId));
        System.out.println(databaseReference.toString());

        CompletableFuture<Product> future = new CompletableFuture<>();

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Convert the DataSnapshot to a Product object and complete the future with the product
                    Product retrievedProduct = dataSnapshot.getValue(Product.class);
                    System.out.println(retrievedProduct.getpName() + " NAMEMEM");
                    future.complete(retrievedProduct);
                } else {
                    // If the product is not found, complete the future exceptionally with a not found exception
                    System.out.println("Product with id " + productId + " not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Error fetching product: " + databaseError.getMessage());
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }
}
