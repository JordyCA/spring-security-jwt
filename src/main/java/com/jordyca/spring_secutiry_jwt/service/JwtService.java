package com.jordyca.spring_secutiry_jwt.service;

import com.jordyca.spring_secutiry_jwt.domain.repository.User;

public interface JwtService {

    String generateToken(User user);

    String generateRefreshToken(User user);

    String buildToken(User user, long expiration);
}
