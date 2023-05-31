package com.example.AuthenticationService.service;

import com.example.AuthenticationService.dto.AuthUser;
import com.example.UserService.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final WebClient.Builder webClientBuilder;
    private List<AuthUser> authUsers = new ArrayList<>();

    /**
     * Authenticate the user
     * @param email
     * @param password
     * @param response
     * @return
     */
    public ResponseEntity<List<HashMap<String, String>>> login(String email, String password, HttpServletResponse response) {
        User user = webClientBuilder.build().get()
                .uri("http://localhost:1080/users/user-exists?email=" + email + "&password=" + password)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        // Control the response
        System.out.println("Result from user-service: " + user);
        if (user != null) {
            // expireation time for 20 seconds
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.HOUR_OF_DAY, 24);

            Date expirationTime = calendar.getTime();
            String secretKey = "secret";
            String jwt = Jwts.builder()
                    .setSubject(user.getId())
                    .setExpiration(expirationTime)
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();

            Cookie cookie = new Cookie("jwt", jwt);
            response.addCookie(cookie);
            cookie.setHttpOnly(true);
            cookie.setDomain("localhost:5173");
            for(AuthUser authUser: authUsers) {
                if(authUser.getUser().getId().equals(user.getId())) {
                    authUsers.remove(authUser);
                    break;
                }
            }
            AuthUser authResponse = new AuthUser(expirationTime, user, jwt);
            authUsers.add(authResponse);
            // Send the cookies through the response body
            return ResponseEntity.ok().body(List.of(new HashMap<>(Map.of("cookie", jwt))));
        } else {
            return ResponseEntity.badRequest().body(List.of(new HashMap<>()));
        }
    }

    /**
     * Check if the user is logged in
     * @param token
     * @return
     */
    public ResponseEntity<String> check(String token) {
        for (AuthUser user: authUsers
             ) {
            if(user.getToken().equals(token)) {
                if(user.getExpireTime().getTime() < System.currentTimeMillis()) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired");
                }else {
                    return ResponseEntity.ok("User is logged in");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in");
    }

    /**
     * Logout the user
     * @param token
     * @param response
     * @return
     */
    public ResponseEntity<String> logout(String token, HttpServletResponse response) {
        for (AuthUser user: authUsers
        ) {
            if(user.getToken().equals(token)) {
                authUsers.remove(user);
                Cookie cookie = new Cookie("jwt", "");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }

        return ResponseEntity.ok("User logged out");
    }

    /**
     * Get all the online users
     * @return
     */
    public ResponseEntity<List<User>> getOnlineUsers() {
        ResponseEntity<List<User>> users = ResponseEntity.ok().body(List.of(authUsers.stream().map(AuthUser::getUser).toArray(User[]::new)));
        System.out.println("Users to return: " + users);
        return users;
    }

}
