package com.example.emailmanagement.controller;

import com.example.emailmanagement.pojos.UserLogin;
import com.example.emailmanagement.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RequestMapping("/api")
@RestController
public class AuthenticationController {
    UserService userService;

    @Autowired
    public AuthenticationController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerNewUser(){
        return "abc";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody UserLogin userLogin){
        return  userService.login(userLogin.email, userLogin.password);
    }
}
