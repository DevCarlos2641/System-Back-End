package com.carlos2641.system.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
