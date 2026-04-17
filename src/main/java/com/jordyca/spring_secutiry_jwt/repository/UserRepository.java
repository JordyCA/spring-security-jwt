package com.jordyca.spring_secutiry_jwt.repository;

import com.jordyca.spring_secutiry_jwt.domain.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
