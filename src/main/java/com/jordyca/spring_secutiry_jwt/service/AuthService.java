package com.jordyca.spring_secutiry_jwt.service;

import com.jordyca.spring_secutiry_jwt.dto.AuthRequestDto;
import com.jordyca.spring_secutiry_jwt.dto.TokenResponseDto;

public interface AuthService {

    TokenResponseDto register(AuthRequestDto.RegisterRequest registerRequest);

    TokenResponseDto login(AuthRequestDto.LoginRequest loginRequest);

    TokenResponseDto refreshToken(String authHeader);
}
