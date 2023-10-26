package com.example.emailmanagement.service;

import com.example.emailmanagement.entity.User;
import com.example.emailmanagement.exception.EtAuthException;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    ResponseEntity<Map<String, String>> login(String email, String password) throws EtAuthException;
    User register(String email, String password, String name) throws EtAuthException;
}