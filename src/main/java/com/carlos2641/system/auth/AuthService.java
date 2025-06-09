package com.carlos2641.system.auth;

import com.carlos2641.system.auth.jwt.JwtService;
import com.carlos2641.system.infrastructure.out.persistence.user.Role;
import com.carlos2641.system.infrastructure.out.persistence.user.UserEntity;
import com.carlos2641.system.infrastructure.out.persistence.user.UserJpaRepository;
import com.carlos2641.system.infrastructure.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserJpaRepository userJpaRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CookieUtil cookieUtil;

    @Value("${jwt.exp}")
    private int expired;

    public ResponseEntity<?> login(AuthRequest request, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new BadCredentialsException("Credenciales invalidas");
        }
        UserDetails user = userJpaRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        AuthResponse responseToken = new AuthResponse();

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(expired);
        cookie.setSecure(false);
        response.addCookie(cookie);
        responseToken.setToken(token);

        return ResponseEntity.ok().body(responseToken);
    }

    // change AuthRequest by other class for more data of the register
    public ResponseEntity<?> register(AuthRegister user){

        Boolean exist = userJpaRepository.existsByEmail(user.getEmail());
        if(exist) return ResponseEntity.badRequest().build();

        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setId_user(null);
        newUserEntity.setUsername(user.getUsername());
        newUserEntity.setEmail(user.getEmail());
        newUserEntity.setPassword(user.getPassword());
        newUserEntity.setRole(Role.ADMIN);

        System.out.println(newUserEntity.toString());

        userJpaRepository.save(newUserEntity);

        AuthResponse response = new AuthResponse();
        response.setToken(jwtService.getToken(newUserEntity));

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> logOut(HttpServletResponse response){
        response.addCookie(cookieUtil.delete("token"));
        return ResponseEntity.ok("");
    }
}
