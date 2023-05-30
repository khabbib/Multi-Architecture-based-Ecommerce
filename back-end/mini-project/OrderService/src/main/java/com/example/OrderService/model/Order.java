package com.example.OrderService.model;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private String orderId;
    private String customerId;
    private ArrayList<ItemList> items; // This will be an array of product IDs.
    private String shippingAddress; // This will be the address of the customer.
    private String billingAddress; // This will be the address of the customer.
    private String paymentMethod; // This will be the payment method of the customer.
    private String orderStatus; // This will be the status of the order.
    private String orderDate; // This will be the date the order was placed.
    private String deliveryDate; // This will be the date the order was delivered.
    private String deliveryCompany; // This will be the company that delivered the order.
    private String trackingNumber; // This will be the tracking number of the order.
    private String deliveryStatus; // This will be the status of the delivery.
    private String deliveryAddress; // This will be the address of the delivery.
    private double totalPriceTax; // This will be the total price of the order including tax.

    public Order() {
    }

    public Order(String customerId, ArrayList<ItemList> items, String shippingAddress, String billingAddress, String paymentMethod, String orderStatus, String orderDate, String deliveryDate, String deliveryCompany, String trackingNumber, String deliveryStatus, String deliveryAddress, double totalPriceTax) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.deliveryCompany = deliveryCompany;
        this.trackingNumber = trackingNumber;
        this.deliveryStatus = deliveryStatus;
        this.deliveryAddress = deliveryAddress;
        this.totalPriceTax = totalPriceTax;
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

    public ArrayList<ItemList> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemList> items) {
        this.items = items;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotalPriceTax() {
        return totalPriceTax;
    }

    public void setTotalPriceTax(double totalPriceTax) {
        this.totalPriceTax = totalPriceTax;
    }

    @Override
    public String toString() {
        return "Order: " + orderId + ", Customer ID: " + customerId + ", Items: " + items + ", Shipping Address: " + shippingAddress + ", Billing Address: " + billingAddress + ", Payment Method: " + paymentMethod + ", Order Status: " + orderStatus + ", Order Date: " + orderDate + ", Delivery Date: " + deliveryDate + ", Delivery Company: " + deliveryCompany + ", Tracking Number: " + trackingNumber + ", Delivery Status: " + deliveryStatus + ", Delivery Address: " + deliveryAddress + ", Total Price Tax: " + totalPriceTax;
    }

}