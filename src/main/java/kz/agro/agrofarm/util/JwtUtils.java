package kz.agro.agrofarm.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import kz.agro.agrofarm.model.enums.TokenType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

/**
 * @author Samat Zhumamuratov
 */

@Component
public class JwtUtils {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.access-token-expiration-time}")
    private long accessTokenExpirationTime;

    @Value("${application.security.jwt.refresh-token-expiration-time}")
    private long refreshTokenExpirationTime;

    public String getTokenByType(TokenType tokenType, String email) {
        return switch (tokenType) {
            case ACCESS -> generateJwtToken(accessTokenExpirationTime, email);
            case REFRESH -> generateJwtToken(refreshTokenExpirationTime, email);
        };
    }

    public String getEmail(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String generateJwtToken(long expirationTime, String email) {
        return Jwts
                .builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
