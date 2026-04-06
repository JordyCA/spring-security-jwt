package com.jordyca.spring_secutiry_jwt.controller;

import com.jordyca.spring_secutiry_jwt.dto.AuthRequestDto;
import com.jordyca.spring_secutiry_jwt.dto.TokenResponseDto;
import com.jordyca.spring_secutiry_jwt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    public final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDto> register(
            @RequestBody AuthRequestDto.RegisterRequest request
    ) {
        TokenResponseDto tokenResponseDto = authService.register(request);
        return ResponseEntity.ok(tokenResponseDto);
    }

}
