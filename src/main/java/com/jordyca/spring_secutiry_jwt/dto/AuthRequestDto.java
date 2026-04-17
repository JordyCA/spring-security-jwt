package com.jordyca.spring_secutiry_jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {

    @Getter
    @Setter
    public static class RegisterRequest {
        private String name;
        private String password;
        private String email;
    }

    @Getter
    @Setter
    public static class LoginRequest {
        private String email;
        private String password;
    }
}

