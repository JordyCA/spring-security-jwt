package com.jordyca.spring_secutiry_jwt.service;

import com.jordyca.spring_secutiry_jwt.domain.repository.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long jwtExpiration;
    @Value("${jwt.refresh-expiration-ms}")
    private long jwtRefreshExpiration;

    @Override
    public String generateToken(User user) {
        return buildToken(user, this.jwtExpiration);
    }

    @Override
    public String generateRefreshToken(User user) {
        return buildToken(user, this.jwtRefreshExpiration);
    }

    @Override
    public String buildToken(User user, long expiration) {
        return Jwts.builder()
                .id(user.getId().toString())
                .claims(Map.of(
                        "Name", user.getName()
                ))
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String extractUserName(String token) {
        Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getSubject();
    }

    @Override
    public Boolean isTokenValid(String token, User user) {
        String userName = extractUserName(token);
        return userName.equals(user.getEmail()) && !isTokenExpiration(token);
    }

    private Boolean isTokenExpiration(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getExpiration();
    }
}
