package com.example.shopeepy.database;

import com.example.shopeepy.model.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FireBaseDb {

    public String createUser(Person person) throws Exception, ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("users").document(person.getPersonId()).set(person);
        return future.get().getUpdateTime().toString();


    }
}
