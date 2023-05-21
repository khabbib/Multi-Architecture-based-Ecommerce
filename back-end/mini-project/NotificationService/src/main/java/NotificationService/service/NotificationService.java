package NotificationService.service;

import NotificationService.model.Notification;
import NotificationService.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public CompletableFuture<List<Notification>> getAllNotifications(String userId) {
        return notificationRepository.getAllNotifications(userId);
    }

    public CompletableFuture<ResponseEntity<String>> createNotification(Notification notification, String userId) {
        return notificationRepository.createNotification(userId, notification);
    }

    public CompletableFuture<Notification> getNotificationById(String userId, String notificationId) {
        return notificationRepository.getNotificationById(userId, notificationId);
    }

    public CompletableFuture<ResponseEntity<String>> deleteNotification(String userId, String notificationId) {
        return notificationRepository.deleteNotification(userId, notificationId);
    }

    public CompletableFuture<ResponseEntity<String>> updateNotification(String userId, String notificationId, Notification notification) {
        return notificationRepository.updateNotification(userId, notificationId, notification);
    }
}
