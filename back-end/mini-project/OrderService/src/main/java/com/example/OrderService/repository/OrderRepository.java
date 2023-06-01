package com.example.OrderService.repository;

import com.example.OrderService.model.ItemList;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Product;
import com.google.firebase.database.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Repository
public class OrderRepository {

    //return all orders from the database
    public CompletableFuture<ArrayList<Order>> findAll() {
        CompletableFuture future = new CompletableFuture<>();
        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("order");
        ordersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ArrayList<Order> orders = new ArrayList<>();
                for (DataSnapshot orderSnapshot : snapshot.getChildren()) {
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
                    //get items
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
                future.complete(orders);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                future.completeExceptionally(error.toException());
            }
        });
        return future;
    }


    //get order by id
    public CompletableFuture<Order> findById(String id) {
        CompletableFuture<Order> future = new CompletableFuture<>();
        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("order");
        Query query = ordersRef.orderByChild("orderId").equalTo(id);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Order order = new Order();
                for (DataSnapshot orderSnapshot : snapshot.getChildren()) {
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

                }
                ResponseEntity<Order> responseEntity = ResponseEntity.ok(order);
                future.complete(responseEntity.getBody());
                query.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                ResponseEntity<List<Order>> errorResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                future.completeExceptionally(new RuntimeException(error.getMessage()));
            }
        });
        return future;
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

    public ResponseEntity<String> save(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        //setTotalPrice(order);
        //updateStock(order);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("order");
        DatabaseReference newOrderReference = databaseReference.push();
        newOrderReference.setValueAsync(order);
        String orderId = newOrderReference.getKey();
        deleteCart(order.getCustomerId());
        return ResponseEntity.ok().body(orderId);
    }

    public void deleteCart(String userId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cart");
        databaseReference.child(userId).removeValueAsync();
    }

    // FIXME - This method is not tested yet
    //Update stock if quantity > 1
    //Remove item from database if quantity = 1
    public ResponseEntity<String> updateStock(Order order){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("product");
        for (ItemList item : order.getItems()) {
            Query query = databaseReference.orderByChild("pId").equalTo(item.getProductId());
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                        Product product = productSnapshot.getValue(Product.class);
                        if (product.getpQuantity() > 1) {
                            product.setpQuantity((long) (product.getpQuantity() - item.getQuantity()));
                            productSnapshot.getRef().setValueAsync(product);
                        } else {
                            productSnapshot.getRef().removeValueAsync();
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    ResponseEntity<String> errorResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            });
        }
        return ResponseEntity.ok().body("Stock updated");
    }

    // FIXME - This method is not tested yet
    //Set total price on order from the list of items
    public ResponseEntity<String> setTotalPrice(Order order) {
        double totalPrice = 0;
        for (ItemList item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        order.setTotalPriceTax(totalPrice);
        return ResponseEntity.ok().body("Total price set");

    }
}
