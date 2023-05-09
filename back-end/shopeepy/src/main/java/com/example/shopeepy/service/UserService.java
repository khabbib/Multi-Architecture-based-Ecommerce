package com.example.shopeepy.service;

import com.example.shopeepy.model.User;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    /**
     * Get all users as a list.
     *
     * @return List<user>
     */
    public CompletableFuture<List<User>> getAllUsers() {
        CompletableFuture<List<User>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the users
                List<User> userList = new ArrayList<>();

                // loop through the children of the snapshot, which represent the individual users
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert the DataSnapshot to a user object and complete the future with the user
                    User retrievedUser = dataSnapshot.getValue(User.class);
                    // add the user to the list
                    userList.add(retrievedUser);
                }

                // complete the future with the list of users
                future.complete(userList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the operation is cancelled or fails, complete the future exceptionally
                future.completeExceptionally(error.toException());
            }
        };

        // attach the listener to the reference and return the future
        ref.addValueEventListener(listener);
        return future;
    }

    /**
     * Get user by ID.
     *
     * @return user
     */
    public CompletableFuture<User> getUserById(String userId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user").child(userId);
        CompletableFuture<User> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Convert the DataSnapshot to a user object and complete the future with the user
                    User retrievedUser = dataSnapshot.getValue(User.class);
                    future.complete(retrievedUser);
                } else {
                    // If the user is not found, complete the future exceptionally with a not found exception
                    System.out.println("User with id " + userId + " not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Error fetching user: " + databaseError.getMessage());
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    /**
     * Create a user.
     *
     * @param user
     * @return
     */
    public ResponseEntity<String> createUser(User user) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user");
        DatabaseReference newUserReference = databaseReference.push();
        newUserReference.setValueAsync(user);
        String userId = newUserReference.getKey();
        return ResponseEntity.ok().body(userId);
    }

    /**
     * Deletes the user with proposed ID.
     *
     * @param id
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> deleteUser(String id) {
        try {
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("user").child(id);
            userRef.removeValueAsync().get();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update a user.
     *
     * @param id
     * @param user
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> updateuser(String id, User user) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user/" + id);
        ref.setValueAsync(user);
        return ResponseEntity.ok("User updated successfully");
    }
}
