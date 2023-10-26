package com.example.emailmanagement.service;

import com.example.emailmanagement.entity.User;
import com.example.emailmanagement.exception.EtAuthException;
import com.example.emailmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Map<String, String>> login(String email, String password) throws EtAuthException {
        User user = userRepository.findByEmailAndPassword(email, password);

        if(user == null){
            throw new EtAuthException("User not authenticated");
        }

        return new ResponseEntity<>(generateToken(user), HttpStatus.OK);
    }

    @Override
    public User register(String email, String password, String name) throws EtAuthException {
        return null;
    }

    private Map<String, String> generateToken(User user) {
        long timestamp = System.currentTimeMillis();
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder().expiration(new Date(timestamp + 2 * 60 * 60 * 1000)).claim("userId", user.getUserId()).claim("email", user.getEmail()).signWith(key).compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}