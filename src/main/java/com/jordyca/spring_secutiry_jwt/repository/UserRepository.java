package com.jordyca.spring_secutiry_jwt.repository;

import com.jordyca.spring_secutiry_jwt.domain.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
