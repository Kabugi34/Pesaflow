package com.pesaflow.service;
import org.springframework.stereotype.Service;
import com.pesaflow.entity.User;
import com.pesaflow.repository.UserRepository;
import java.util.List;
import com.pesaflow.exception.UserNotFoundException;
import com.pesaflow.dto.UserResponse;


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
    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    public UserResponse getUserById(Long id){
        User user =userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return new UserResponse(
        user.getId(), 
        user.getName(), 
        user.getEmail());
    }
    public User updateUser(String name ,String email,Long id){
        User user =userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        User user =userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
