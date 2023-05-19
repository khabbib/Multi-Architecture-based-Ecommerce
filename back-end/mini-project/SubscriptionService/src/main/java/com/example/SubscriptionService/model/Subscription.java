package com.example.SubscriptionService.model;

import java.util.ArrayList;
import java.util.List;

public class Subscription {
    private List<String> subscriptions;
    private String id;

    public Subscription() {
        subscriptions = new ArrayList<>();
    }

    public List<String> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<String> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
