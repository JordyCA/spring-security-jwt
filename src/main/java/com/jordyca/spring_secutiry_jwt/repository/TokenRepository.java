package com.jordyca.spring_secutiry_jwt.repository;

import com.jordyca.spring_secutiry_jwt.domain.repository.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {

    List<Token> findAllByUserIdAndExpiredFalseAndRevokedFalse(Long userId);
}
