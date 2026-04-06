package com.jordyca.spring_secutiry_jwt.repository;

import com.jordyca.spring_secutiry_jwt.domain.repository.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
