package com.example.CartsService.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class Cart {
    private double cartId;
    private double customerId;
    private double orderId;
    private ArrayList<Double> productIds;


    public Cart(double cartId, double customerId, double orderId, ArrayList<Double> productIds) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.productIds = productIds;
    }

    public Cart(double cartId, double customerId, double orderId){
        this.cartId = cartId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.productIds = new ArrayList<>();
    }

    public ArrayList<Double> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<Double> productIds) {
        this.productIds = productIds;
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
                ", product ID:s ='" + productIds.toString() + '\'' +
                '}';
    }
}
