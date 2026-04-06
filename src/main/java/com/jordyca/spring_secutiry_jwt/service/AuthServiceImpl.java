package com.jordyca.spring_secutiry_jwt.service;

import com.jordyca.spring_secutiry_jwt.domain.model.TokenType;
import com.jordyca.spring_secutiry_jwt.domain.repository.Token;
import com.jordyca.spring_secutiry_jwt.domain.repository.User;
import com.jordyca.spring_secutiry_jwt.dto.AuthRequestDto;
import com.jordyca.spring_secutiry_jwt.dto.TokenResponseDto;
import com.jordyca.spring_secutiry_jwt.repository.TokenRepository;
import com.jordyca.spring_secutiry_jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public TokenResponseDto register(AuthRequestDto.RegisterRequest registerRequest) {
        User newUser = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        User savedUser = userRepository.save(newUser);
        String jwtToken = jwtService.generateToken(savedUser);
        String jwtTokenRefresh = jwtService.generateRefreshToken(savedUser);

        saveToken(savedUser, jwtToken);

        return TokenResponseDto.builder()
                .accessToken(jwtToken)
                .refreshToken(jwtTokenRefresh)
                .build();
    }

    private void saveToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(Boolean.FALSE)
                .revoked(Boolean.FALSE)
                .build();
        tokenRepository.save(token);
    }
}
