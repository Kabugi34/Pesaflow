package com.pesaflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.*;
@Getter
@Setter
public class CreateUserRequest {
    @NotBlank 
    private String name;
    @NotBlank
    @Email
    private String email;
}