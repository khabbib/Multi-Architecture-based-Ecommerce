package com.example.shopeepy.api.auth;

import com.example.shopeepy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    public String login(String username, String password) {
        return loginService.login(username, password);
    }

    public String logout(String username) {
        return loginService.logout(username);
    }

}
