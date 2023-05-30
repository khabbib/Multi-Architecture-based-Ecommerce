package com.example.OrderService.repository;

import com.example.OrderService.model.ItemList;
import com.example.OrderService.model.Order;
import com.example.util.FirebaseInitializer;
import com.google.firebase.database.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class OrderRepository {
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> findAll() {
        return orders;
    }

    public Order findById(String id) {
        Order order = orders.stream().filter(ord -> ord.getOrderId().equals(id)).findFirst().orElse(null);
        return order;
    }

    public CompletableFuture<ResponseEntity<List<Order>>> getOrdersByCustomerId(String customerId) {
        CompletableFuture<ResponseEntity<List<Order>>> future = new CompletableFuture<>();

        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("order");
        Query query = ordersRef.orderByChild("customerId").equalTo(customerId);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Order> orders = new ArrayList<>();

                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    Order order = new Order();
                    order.setOrderId(orderSnapshot.child("orderId").getValue(String.class));
                    order.setCustomerId(orderSnapshot.child("customerId").getValue(String.class));
                    order.setShippingAddress(orderSnapshot.child("shippingAddress").getValue(String.class));
                    order.setBillingAddress(orderSnapshot.child("billingAddress").getValue(String.class));
                    order.setPaymentMethod(orderSnapshot.child("paymentMethod").getValue(String.class));
                    order.setOrderStatus(orderSnapshot.child("orderStatus").getValue(String.class));
                    order.setOrderDate(orderSnapshot.child("orderDate").getValue(String.class));
                    order.setDeliveryDate(orderSnapshot.child("deliveryDate").getValue(String.class));
                    order.setDeliveryCompany(orderSnapshot.child("deliveryCompany").getValue(String.class));
                    order.setTrackingNumber(orderSnapshot.child("trackingNumber").getValue(String.class));
                    order.setDeliveryStatus(orderSnapshot.child("deliveryStatus").getValue(String.class));
                    order.setDeliveryAddress(orderSnapshot.child("deliveryAddress").getValue(String.class));
                    order.setTotalPriceTax(orderSnapshot.child("totalPriceTax").getValue(Double.class));

                    ArrayList<ItemList> items = new ArrayList<>();
                    for (DataSnapshot itemSnapshot : orderSnapshot.child("items").getChildren()) {
                        String productId = itemSnapshot.child("productId").getValue(String.class);
                        int quantity = itemSnapshot.child("quantity").getValue(Integer.class);
                        double price = itemSnapshot.child("price").getValue(Double.class);

                        ItemList item = new ItemList(productId, quantity, price);
                        items.add(item);
                    }
                    order.setItems(items);

                    orders.add(order);
                }

                ResponseEntity<List<Order>> responseEntity = ResponseEntity.ok(orders);
                future.complete(responseEntity);

                query.removeEventListener(this); // Remove the listener to avoid further updates
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                ResponseEntity<List<Order>> errorResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                future.completeExceptionally(new RuntimeException(databaseError.getMessage()));
            }
        });

        return future;
    }

    public void save(Order order) {
        orders.add(order);
    }
}
