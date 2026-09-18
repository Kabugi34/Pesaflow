package com.pesaflow.dto;
import lombok.*;
@AllArgsConstructor
@Getter 
public class UserResponse {
    private Long id;
    private String name;
    private String email;
}
