package com.example.shopeepy.api.auth;

import com.example.shopeepy.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

public class Authentication {

    @Autowired
    private AuthenticationService authenticationService;


    public Boolean authenticate(String username, String password) {
        return true;
    }

}
