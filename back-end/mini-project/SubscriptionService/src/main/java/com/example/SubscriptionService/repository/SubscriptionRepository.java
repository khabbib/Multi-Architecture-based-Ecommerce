package com.example.SubscriptionService.repository;

import com.example.SubscriptionService.model.Subscription;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Repository
public class SubscriptionRepository {
    public SubscriptionRepository() {
        System.out.println("SubscriptionRepository created");
    }

    public CompletableFuture<List<Subscription>> getAllSubscriptions() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("subscription");
        CompletableFuture<List<Subscription>> future = new CompletableFuture<>();

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Subscription> subscriptions = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Subscription subscription = new Subscription();
                    subscription.setId(snapshot.getKey());
                    for (DataSnapshot arraySnapshot : snapshot.getChildren()) {
                        String value = arraySnapshot.child("pType").getValue(String.class);
                        if (value != null) {
                            subscription.getSubscriptions().add(value);
                        }
                    }
                    subscriptions.add(subscription);
                }
                future.complete(subscriptions);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }


    public ResponseEntity<String> createSubscription(Subscription subscription, String id) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("subscription").child(id);
        List<Object> subscriptionList = new ArrayList<>();

        for (String value : subscription.getSubscriptions()) {
            Map<String, String> subscriptionMap = new HashMap<>();
            subscriptionMap.put("pType", value);
            subscriptionList.add(subscriptionMap);
        }

        databaseReference.setValueAsync(subscriptionList);
        return ResponseEntity.ok("Subscription created successfully");
    }

    public CompletableFuture<Subscription> getSubscriptionById(String id) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("subscription").child(id);
        CompletableFuture<Subscription> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Subscription subscription = new Subscription();
                    for (DataSnapshot arraySnapshot : dataSnapshot.getChildren()) {
                        String value = arraySnapshot.child("pType").getValue(String.class);
                        if (value != null) {
                            subscription.getSubscriptions().add(value);
                        }
                    }

                    future.complete(subscription);
                } else {
                    System.out.println("Subscription with id " + id + " not found");
                    future.complete(null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public ResponseEntity<String> deleteSubscription(String id) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("subscription").child(id);
        databaseReference.removeValueAsync();
        return ResponseEntity.ok("Subscription deleted successfully");
    }

    public ResponseEntity<String> updateSubscription(String id, Subscription subscription) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("subscription").child(id);
        List<Object> subscriptionList = new ArrayList<>();

        for (String value : subscription.getSubscriptions()) {
            Map<String, String> subscriptionMap = new HashMap<>();
            subscriptionMap.put("pType", value);
            subscriptionList.add(subscriptionMap);
        }

        databaseReference.setValueAsync(subscriptionList);
        return ResponseEntity.ok("Subscription updated successfully");
    }

}
