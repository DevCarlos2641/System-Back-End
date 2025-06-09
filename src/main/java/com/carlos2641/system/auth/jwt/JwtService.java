package com.carlos2641.system.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;


@Service
public class JwtService {

    private final String SecretKey = "12123123123123123123123123123123123102020202931012091230912309120913";

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }
    @Value("${jwt.exp}")
    private int expired;

    private String getToken(Map<String, Objects> extraClaims, UserDetails user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis() + expired)))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        
    }

    private Key getKey() {
        byte[] keyB = Decoders.BASE64.decode(SecretKey);
        return Keys.hmacShaKeyFor(keyB);
    }

    public String getUsernameFromToken(String token) throws Exception {
        return getClaims(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails us) throws Exception {
        String username = getUsernameFromToken(token);
        return (username.equals(us.getUsername()) && !isExpired(token));
    }

    private Claims getClaims(String token) throws Exception{
        return Jwts.parser()
                .setSigningKey(SecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private  <T> T getClaims(String token, Function<Claims, T> claimsResolver) throws Exception {
        Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Boolean isExpired(String token) throws Exception {
        return getClaims(token, Claims::getExpiration).before(new Date());
    }
}
