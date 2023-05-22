package com.example.SubscriptionService.service;

import com.example.SubscriptionService.model.Subscription;
import com.example.SubscriptionService.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public CompletableFuture<List<Subscription>> getAllSubscriptions() {
        return subscriptionRepository.getAllSubscriptions();
    }

    public void createSubscription(Subscription subscription, String id) {
        subscriptionRepository.createSubscription(subscription, id);
    }

    public CompletableFuture<Subscription> getSubscriptionById(String id) {
        return subscriptionRepository.getSubscriptionById(id);
    }

    public ResponseEntity<String> deleteSubscription(String id) {
        return subscriptionRepository.deleteSubscription(id);
    }

    public ResponseEntity<String> updateSubscription(String id, Subscription subscription) {
        return subscriptionRepository.updateSubscription(id, subscription);
    }
}