package com.pesaflow.controller;
import com.pesaflow.dto.CreateUserRequest;
import com.pesaflow.entity.User;
import com.pesaflow.service.UserService;
import jakarta.validation.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody CreateUserRequest request) {

        return userService.createUser(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
    }
}
