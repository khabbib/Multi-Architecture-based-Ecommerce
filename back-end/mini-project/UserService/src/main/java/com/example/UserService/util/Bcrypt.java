package com.example.UserService.util;

import org.springframework.security.crypto.bcrypt.BCrypt;


public class Bcrypt {
    static public String hash(String password) {
        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = BCrypt.checkpw(password, generatedSecuredPasswordHash);
        System.out.println(matched);
        return generatedSecuredPasswordHash;
    }

    static public boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
