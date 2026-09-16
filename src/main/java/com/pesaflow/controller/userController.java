package com.pesaflow.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.pesaflow.dto.CreateUserRequest;
import jakarta.validation.Valid;


@RestController
public class userController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id)
         {
        return "user id:" +id ;
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the userController!";
    }
   @PostMapping("/users")
    public String createUser(@Valid @RequestBody CreateUserRequest request) {

        return "Name: " + request.getName()
            + ", Email: " + request.getEmail();
}
}
