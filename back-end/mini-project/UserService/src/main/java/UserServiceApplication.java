
import com.example.util.FirebaseInitializer;
import model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import repository.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// This is a method that will run when the application starts.
	// It will add some data to the database.
	// This is just for testing purposes.
	@Bean
	public CommandLineRunner test(UserRepository repository) {
		return (args) -> {
			FirebaseInitializer.initializeFireBase();

			// Get all users
			CompletableFuture<List<User>> users = repository.getAllUsers();
			System.out.println("All users: " + users.get());

			// Get a product by ID
			CompletableFuture<User> user = repository.getUserById("36f20b15-71a1-4679-8750-1e5b88d60dae");
			System.out.println("User by ID: " + user.get());

			// Delete a product
			ResponseEntity<String> status = repository.deleteUser("XXX");
			if(status.toString().contains("204")){
				System.out.println("User not found" + status);
			}else {
				System.out.println("User deleted successfully" + status );
			}
		};
	}

}
