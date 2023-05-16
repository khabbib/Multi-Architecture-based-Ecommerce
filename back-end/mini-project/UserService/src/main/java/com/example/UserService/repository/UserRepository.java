package com.example.UserService.repository;

import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import com.example.UserService.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {
    public UserRepository() {
        System.out.println("UserRepository created");
    }

    /**
     * Get all users as a list.
     * @return List<User>
     */
    public CompletableFuture<List<User>> getAllUsers() {
        CompletableFuture<List<User>> future = new CompletableFuture<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // create a list to hold the users
                List<User> userList = new ArrayList<>();

                // loop through the children of the snapshot, which represent the individual Users
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Convert the DataSnapshot to a User object and complete the future with the User
                    User retrievedUser = dataSnapshot.getValue(User.class);
                    // add the User to the list
                    userList.add(retrievedUser);
                }

                // complete the future with the list of Users
                future.complete(userList);
                System.out.println("Successfully retrieved " + userList.size() + " users.");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the operation is cancelled or fails, complete the future exceptionally
                future.completeExceptionally(error.toException());
                System.err.println("Error retrieving users: " + error.getMessage());
            }
        };

        // attach the listener to the reference and return the future
        ref.addValueEventListener(listener);
        System.out.println("Fetching users...");
        return future;
    }


    /**
     * Get user by ID.
     * @return User
     */
    public CompletableFuture<User> getUserById(String userID) throws ExecutionException, InterruptedException {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user").child(String.valueOf(userID));
        CompletableFuture<User> future = new CompletableFuture<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Convert the DataSnapshot to a User object and complete the future with the User
                    User retrievedUser = dataSnapshot.getValue(User.class);
                    future.complete(retrievedUser);
                } else {
                    // If the User is not found, complete the future exceptionally with a not found exception
                    System.out.println("User with id " + userID + " not found");
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
     * Create a user.
     * @param user
     * @return String
     */
    public ResponseEntity<String> createUser(User user) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user");
        DatabaseReference newUserReference = databaseReference.push();
        newUserReference.setValueAsync(user);
        String UserId = newUserReference.getKey();
        return ResponseEntity.ok().body(UserId);
    }

    /**
     * Deletes the User with proposed ID.
     * @param id
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> deleteUser(String id) {
        try {
            DatabaseReference UserRef = FirebaseDatabase.getInstance().getReference("user").child(id);
            UserRef.removeValueAsync().get();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update a user.
     * @param id
     * @param user
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> updateUser(String id, User user) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user/" + id);
        ref.setValueAsync(user);
        return ResponseEntity.ok("User updated successfully");
    }

    public void deleteAllUsers() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("User");
        ref.removeValueAsync();
    }
}
