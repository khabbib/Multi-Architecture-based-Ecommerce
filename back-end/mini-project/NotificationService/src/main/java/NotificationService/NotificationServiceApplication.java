package NotificationService;

import NotificationService.model.Notification;
import NotificationService.repository.NotificationRepository;

import com.example.util.FirebaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(NotificationRepository repository) {
		return args -> {
			FirebaseInitializer.initializeFireBase("notification");
			String userId = UUID.randomUUID().toString();
			String notificationId = UUID.randomUUID().toString();

			System.out.println("Test for user: " + userId + " and notification: " + notificationId);

			// Test createNotification
			Notification notification = new Notification();
			notification.setDate("31/12/1998");
			notification.setpName("Volvo");
			notification.setpType("Vehicle");

			CompletableFuture<ResponseEntity<String>> createNotificationFuture = repository.createNotification(userId, notification);
			createNotificationFuture.thenAccept(response -> {
				System.out.println("createNotification result: " + response.getBody());
			}).join();

			// Test getAllNotifications
			CompletableFuture<List<Notification>> getAllNotificationsFuture = repository.getAllNotifications(userId);
			getAllNotificationsFuture.thenAccept(notifications -> {
				System.out.println("getAllNotifications result:");
				for (Notification notification2 : notifications) {
					System.out.println(notification2.getId());
				}
			}).join();

			notificationId = getAllNotificationsFuture.get().get(0).getId();

			// Test getNotificationById
			CompletableFuture<Notification> getNotificationByIdFuture = repository.getNotificationById(userId, notificationId);
			getNotificationByIdFuture.thenAccept(notificationResult -> {
				System.out.println("getNotificationById result:");
				System.out.println(notificationResult);
			}).join();

			notification.setDate("21/11/2099");
			notification.setpName("Opel");
			notification.setpType("Fordon");

			// Test updateNotification
			CompletableFuture<ResponseEntity<String>> updateNotificationFuture = repository.updateNotification(userId, notificationId, notification);
			updateNotificationFuture.thenAccept(response -> {
				System.out.println("updateNotification result: " + response.getBody());
			}).join();

			// Test deleteNotification
			CompletableFuture<ResponseEntity<String>> deleteNotificationFuture = repository.deleteNotification(userId, notificationId);
			deleteNotificationFuture.thenAccept(response -> {
				System.out.println("deleteNotification result: " + response.getBody());
			}).join();
		};
	}
}