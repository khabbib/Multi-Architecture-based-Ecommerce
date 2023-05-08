package com.example.shopeepy.service.db;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FireBaseInitializer {
    @PostConstruct
    public void initializeFireBase() throws IOException {
        System.out.println("FireBaseInitializer created");
        FileInputStream serviceAccount = new FileInputStream("back-end/shopeepy/serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://shopeepy-db-1.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
    }
}
