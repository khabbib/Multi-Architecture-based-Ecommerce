package com.example.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {
    public static void initializeFireBase() throws IOException {
        Dotenv dotenv = Dotenv.configure().load();
        String serviceAccountKeyPath = dotenv.get("FIREBASE_SERVICE_ACCOUNT_KEY_PATH");
        FileInputStream serviceAccount = new FileInputStream(serviceAccountKeyPath);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://shopeepy-db-1.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        System.out.println("Firebase initialized");
    }
}
