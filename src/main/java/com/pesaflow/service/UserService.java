package com.pesaflow.service;
import org.springframework.stereotype.Service;
import com.pesaflow.entity.User;
import com.pesaflow.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(String name ,String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

}
