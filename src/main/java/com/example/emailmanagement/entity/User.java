package com.example.emailmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;

    private enum Status {
        ACTIVE,
        INACTIV
    }

    @Column(name = "status")
    @Enumerated
    private Status status;
}