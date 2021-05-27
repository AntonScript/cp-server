package com.example.cpserver.congif;


import com.example.cpserver.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expirationTime;

    public String extractUsername(String authToken) {
        return getClaimsFromToken(authToken)
                .getSubject();
    }

    public Claims getClaimsFromToken(String authToken) {
        String key = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody();
    }

    public Integer extractUserId(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
        Integer userId = (Integer) body.get("user_id");
        return userId;
    }

    public String extractUserRole(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
        String role = (String) body.get("role");
        return role;
    }

    public boolean validateToken(String authToken) {
        return getClaimsFromToken(authToken)
                .getExpiration()
                .after(new Date());
    }

    public String generateToken(User user){
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("role",user.getRole());
        claims.put("user_id",user.getId());

        Long expirationSeconds = Long.parseLong(expirationTime);
        Date createDate = new Date();
        Date expirationDate = new Date(createDate.getTime() + expirationSeconds * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(createDate)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

}