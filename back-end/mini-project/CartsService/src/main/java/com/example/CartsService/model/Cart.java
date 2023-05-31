package com.example.CartsService.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private double cartId;
    private double customerId;
    private double orderId;
    private Map<String, String> productList;
    //Hashmapen innehåller först produktid, sedan antalet av produkten.

    public Cart(double orderId, double cartId, double customerId, Map<String, String> productList){
        this.cartId = cartId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.productList = productList;
    }

    public Cart(){

    }

    public Map<String, String> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, String> productList) {
        this.productList = productList;
    }

    public double getCartId() {
        return cartId;
    }

    public void setCartId(double cartId) {
        this.cartId = cartId;
    }

    public double getOrderId() {
        return orderId;
    }

    public void setOrderId(double orderId) {
        this.orderId = orderId;
    }

    public double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(double customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart ID='" + cartId + '\'' +
                ", customer ID='" + customerId + '\'' +
                ", order ID ='" + orderId + '\'' +
                ", product list ='" + productList.toString() + '\'' +
                '}';
    }
}
