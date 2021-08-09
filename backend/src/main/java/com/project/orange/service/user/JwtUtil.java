package com.project.orange.service.user;

import com.project.orange.entity.user.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    //토큰 유효 시간 설정
    public final static long TOKEN_VALIDATION_SECOND = 1000L * 10;
    public final static long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;

    final static public String ACCESS_TOKEN_NAME = "accessToken";
    final static public String REFRESH_TOKEN_NAME = "refreshToken";

    @Value("${spring.jwt.secret}")
    private String SECRET_KEY;

    private Key getSigningKey(String secretKey){
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //토큰이 유효한 토큰인지 검사한 후, 토큰에 담긴 payload값을 가져온다.(토큰 해석)
    public Claims extractAllClaims(String token) throws ExpiredJwtException{
        return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey(SECRET_KEY))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

    }

    //추출한 Payload로부터 userName을 가져온다.
    public String getEmail(String token) throws ExpiredJwtException {
        return extractAllClaims(token).get("username",String.class);
    }

    //토큰이 만료됐는지 안 됐는지 확인
    public Boolean isTokenExpired(String token){
        final Date expiration = extractAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    //Access Token 생성
    public String generateToken(Users user) {
        return doGenerateToken(user.getEmail(), TOKEN_VALIDATION_SECOND);
    }

    //Refresh Token 생성
    public String generateRefreshToken(Users user) {
        return doGenerateToken(user.getEmail(), REFRESH_TOKEN_VALIDATION_SECOND);
    }

    //토큰을 생성, 페이로드에 담길 값은 username => username || email
    public String doGenerateToken(String username, long expireTime) {

        Claims claims = Jwts.claims();
        claims.put("username", username);

        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }

    //UserDetails : Spring Security에서 사용자의 정보를 담는 인터페이스
    //username은 계정의 고유한 값
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getEmail(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}



