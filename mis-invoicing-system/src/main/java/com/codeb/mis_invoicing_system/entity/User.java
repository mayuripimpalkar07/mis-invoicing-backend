package com.codeb.mis_invoicing_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role; // e.g. "ADMIN" or "SALES"

    @Column(nullable = false)
    private boolean emailVerified = false;

    private String verificationToken;

    private String resetToken;
    private java.time.LocalDateTime resetTokenExpiry;



}