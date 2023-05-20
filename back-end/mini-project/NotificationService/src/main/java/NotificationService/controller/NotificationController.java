package NotificationService.controller;

import NotificationService.model.Notification;
import NotificationService.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/")
    public CompletableFuture<List<Notification>> getAllNotifications(@RequestParam("userId") String userId) {
        return notificationService.getAllNotifications(userId);
    }

    @PostMapping("/")
    public CompletableFuture<ResponseEntity<String>> createNotification(@RequestParam("userId") String userId, @RequestBody Notification notification) {
        return notificationService.createNotification(notification, userId);
    }

    @GetMapping("/{notificationId}")
    public CompletableFuture<Notification> getNotificationById(@RequestParam("userId") String userId, @PathVariable("notificationId") String notificationId) {
        return notificationService.getNotificationById(userId, notificationId);
    }

    @DeleteMapping("/{notificationId}")
    public CompletableFuture<ResponseEntity<String>> deleteNotification(@RequestParam("userId") String userId, @PathVariable("notificationId") String notificationId) {
        return notificationService.deleteNotification(userId, notificationId);
    }

    @PutMapping("/{notificationId}")
    public CompletableFuture<ResponseEntity<String>> updateNotification(@RequestParam("userId") String userId, @PathVariable("notificationId") String notificationId, @RequestBody Notification notification) {
        return notificationService.updateNotification(userId, notificationId, notification);
    }
}
