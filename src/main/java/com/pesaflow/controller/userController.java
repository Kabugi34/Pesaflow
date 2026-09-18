package com.pesaflow.controller;

import com.pesaflow.dto.CreateUserRequest;
import com.pesaflow.entity.User;
import com.pesaflow.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;


@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the userController!";
    }
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody CreateUserRequest request) {

        return userService.createUser(request.getName(), request.getEmail());  
    }
    @GetMapping ("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/users/{id}")
    public User updateUser(@Valid @RequestBody CreateUserRequest request, @PathVariable Long id) {
        return userService.updateUser(request.getName(), request.getEmail(), id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
