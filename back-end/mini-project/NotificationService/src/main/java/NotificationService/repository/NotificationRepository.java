package NotificationService.repository;

import NotificationService.model.Notification;
import com.google.firebase.database.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class NotificationRepository {

    public CompletableFuture<List<Notification>> getAllNotifications(String userId) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("notification").child(userId);
        CompletableFuture<List<Notification>> future = new CompletableFuture<>();

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Notification> notifications = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Notification notification = snapshot.getValue(Notification.class);
                    if (notification != null) {
                        notification.setId(snapshot.getKey());
                        notifications.add(notification);
                    }
                }
                future.complete(notifications);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public CompletableFuture<ResponseEntity<String>> createNotification(String userId, Notification notification) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("notification").child(userId);
        String notificationId = databaseReference.push().getKey();
        if (notificationId != null) {
            notification.setId(notificationId);
            databaseReference.child(notificationId).setValueAsync(notification);
            return CompletableFuture.completedFuture(ResponseEntity.ok().build());
        } else {
            return CompletableFuture.completedFuture(ResponseEntity.status(500).build());
        }
    }

    public CompletableFuture<Notification> getNotificationById(String userId, String notificationId) {
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("notification").child(userId).child(notificationId);
        CompletableFuture<Notification> future = new CompletableFuture<>();

        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Notification notification = dataSnapshot.getValue(Notification.class);
                if (notification != null) {
                    notification.setId(dataSnapshot.getKey());
                    future.complete(notification);
                } else {
                    System.out.println("Notification with id " + notificationId + " not found");
                    future.complete(null);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public CompletableFuture<ResponseEntity<String>> deleteNotification(String userId, String notificationId) {
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("notification").child(userId).child(notificationId);
        userReference.removeValueAsync();
        return CompletableFuture.completedFuture(ResponseEntity.ok("Notification deleted successfully"));
    }

    public CompletableFuture<ResponseEntity<String>> updateNotification(String userId, String notificationId, Notification notification) {
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("notification").child(userId).child(notificationId);
        notification.setId(notificationId);
        userReference.setValueAsync(notification);
        return CompletableFuture.completedFuture(ResponseEntity.ok("Notification updated successfully"));
    }
}
