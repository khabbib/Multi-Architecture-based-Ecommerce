package NotificationService;

import NotificationService.model.Notification;
import NotificationService.repository.NotificationRepository;

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
			NotificationRepository notificationRepository = new NotificationRepository();
			String userId = UUID.randomUUID().toString();
			String notificationId = UUID.randomUUID().toString();

			// Test createNotification
			Notification notification = new Notification();
			CompletableFuture<ResponseEntity<String>> createNotificationFuture = notificationRepository.createNotification(userId, notification);
			createNotificationFuture.thenAccept(response -> {
				System.out.println("createNotification result: " + response.getBody());
			}).join();

			// Test getAllNotifications
			CompletableFuture<List<Notification>> getAllNotificationsFuture = notificationRepository.getAllNotifications(userId);
			getAllNotificationsFuture.thenAccept(notifications -> {
				System.out.println("getAllNotifications result:");
				for (Notification notification2 : notifications) {
					System.out.println(notification2);
				}
			}).join();

			// Test getNotificationById
			CompletableFuture<Notification> getNotificationByIdFuture = notificationRepository.getNotificationById(userId, notificationId);
			getNotificationByIdFuture.thenAccept(notificationResult -> {
				System.out.println("getNotificationById result:");
				System.out.println(notificationResult);
			}).join();

			// Test deleteNotification
			CompletableFuture<ResponseEntity<String>> deleteNotificationFuture = notificationRepository.deleteNotification(userId, notificationId);
			deleteNotificationFuture.thenAccept(response -> {
				System.out.println("deleteNotification result: " + response.getBody());
			}).join();

			// Test updateNotification
			CompletableFuture<ResponseEntity<String>> updateNotificationFuture = notificationRepository.updateNotification(userId, notificationId, notification);
			updateNotificationFuture.thenAccept(response -> {
				System.out.println("updateNotification result: " + response.getBody());
			}).join();
		};
	}

}
