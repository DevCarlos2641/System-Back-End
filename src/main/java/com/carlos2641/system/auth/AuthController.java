package com.carlos2641.system.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    private ResponseEntity<?> login(@RequestBody AuthRequest authRequest, HttpServletResponse response){
        return authService.login(authRequest, response);
    }

    @GetMapping("/logout")
    private ResponseEntity<?> logout(HttpServletResponse response){
        return authService.logOut(response);
    }

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody AuthRegister authRequest){
        return  authService.register(authRequest);
    }

}
