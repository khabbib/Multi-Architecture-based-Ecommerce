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
            case "cart":
                return "https://mini-project-cart.europe-west1.firebasedatabase.app";
            case "product":
                return "https://mini-project-product.europe-west1.firebasedatabase.app";
            case "order":
                return "https://mini-project-order.europe-west1.firebasedatabase.app";
            case "user":
                return "https://mini-project-user.europe-west1.firebasedatabase.app";
            case "subscription":
                return "https://mini-project-subscription.europe-west1.firebasedatabase.app";
            case "notification":
                return "https://mini-project-notification.europe-west1.firebasedatabase.app";
            default:
                return "Invalid database name";
        }
    }


}
