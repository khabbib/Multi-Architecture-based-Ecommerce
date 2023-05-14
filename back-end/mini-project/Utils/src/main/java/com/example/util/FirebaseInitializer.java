package com.example.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {
    public static void initializeFireBase(String dbName) throws IOException {
        String databaseUrl = getDatabaseUrl(dbName);
        Dotenv dotenv = Dotenv.configure().load();
        String serviceAccountKeyPath = dotenv.get("FIREBASE_SERVICE_ACCOUNT_KEY_PATH");
        FileInputStream serviceAccount = new FileInputStream(serviceAccountKeyPath);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(databaseUrl)
                .build();
        FirebaseApp.initializeApp(options);
        System.out.println("Firebase initialized");
    }

    public static String getDatabaseUrl(String dbName) {
        switch (dbName) {
            case "product":
                return "https://mini-project-product.firebaseio.com/";
            case "order":
                return "https://mini-project-order.firebaseio.com/";
            case "user":
                return "https://mini-project-user.firebaseio.com/";
            default:
                return "Invalid database name";
        }
    }


}
