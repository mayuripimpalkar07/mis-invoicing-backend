package com.codeb.mis_invoicing_system.repository;

import com.codeb.mis_invoicing_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByVerificationToken(String token);
    Optional<User> findByResetToken(String token);
    Optional<User> findByEmail(String email);
}