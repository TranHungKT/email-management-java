package com.example.emailmanagement.pojos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLogin {
    @Email
    @NotBlank(message = "Email is mandatory")
    public String email;

    @NotBlank(message = "Password is mandatory")
    public String password;
}