package com.carlos2641.system.infrastructure.in.web;

import com.carlos2641.system.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/remember-me")
    private ResponseEntity<?> remember() {
        return ResponseEntity.ok("");
    }

}
