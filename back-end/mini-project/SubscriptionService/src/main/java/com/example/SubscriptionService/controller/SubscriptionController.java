package com.example.SubscriptionService.controller;

import com.example.SubscriptionService.model.Subscription;
import com.example.SubscriptionService.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Controller for subscriptions.
 */
@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    /**
     * Returns all subscriptions.
     *
     * @return ResponseEntity<List<Subscription>>
     */
    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<Subscription>>> getAvailableSubscriptions() {
        return subscriptionService.getAllSubscriptions()
                .thenApply(subscriptions -> ResponseEntity.ok().body(subscriptions))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a subscription.
     *
     * @param subscription
     */
    @PostMapping("/create")
    public void createSubscription(@RequestBody Subscription subscription, String id) {
        subscriptionService.createSubscription(subscription, id);
    }

    /**
     * Returns a subscription based on ID.
     *
     * @param id
     * @return ResponseEntity<Subscription>
     */
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Subscription>> getSubscriptionById(@PathVariable("id") String id) {
        return subscriptionService.getSubscriptionById(id)
                .thenApply(subscription -> ResponseEntity.ok().body(subscription))
                .exceptionally(e -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a subscription based on ID.
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable("id") String id) {
        return subscriptionService.deleteSubscription(id);
    }

    /**
     * Updates a subscription based on ID.
     *
     * @param id
     * @param subscription
     * @return ResponseEntity<String>
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSubscription(@PathVariable("id") String id, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(id, subscription);
    }
}
