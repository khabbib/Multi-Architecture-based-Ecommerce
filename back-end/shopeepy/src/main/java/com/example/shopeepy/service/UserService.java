package com.example.shopeepy.service;

import com.example.shopeepy.model.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public String createUser(Person person) throws Exception, ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("users").document(person.getPersonId()).set(person);
        return future.get().getUpdateTime().toString();

    }

    public List<Person> getActiveUsers() {
        Person person = new Person("1", "John", "Doe", "1234567890", "admin");
        return new ArrayList<Person>() {{
            add(person);
        }};
    }
}
