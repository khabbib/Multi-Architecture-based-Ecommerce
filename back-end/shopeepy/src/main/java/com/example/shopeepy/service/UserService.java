package com.example.shopeepy.service;

import com.example.shopeepy.model.Person;
import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class UserService {
    private final DatabaseReference ref;
    public UserService() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        ref = db.getReference("users");
    }

    public String createUser(Person person) throws Exception, ExecutionException, InterruptedException {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("/");
        ref.child("users").child(person.getPersonId()).setValueAsync(person);
        return "Created User";
    }

    public List<Person> getActiveUsers() {
        Person person = new Person("1", "John", "Doe", "1234567890", "admin");
        return new ArrayList<Person>() {{
            add(person);
        }};
    }

    public Person getUserById(String id) {
       return (Person) getUserObject(id);
    }


    public Future<Person> getUserObject(String userId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");
        CompletableFuture<Person> future = new CompletableFuture<>();
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Person user = dataSnapshot.getValue(Person.class);
                future.complete(user);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(new Exception("Error reading user: " + databaseError.getCode()));
            }
        };
        usersRef.child(userId).addListenerForSingleValueEvent(userListener);
        return future;
    }

}
