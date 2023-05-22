package com.example.CartsService.model;

import java.util.ArrayList;

public class Cart {

    private String cartId;
    private String orderId;
    private String customerId;

    public Cart(String cartId, String orderId, String customerId) {
        this.cartId = cartId;
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public Cart() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
