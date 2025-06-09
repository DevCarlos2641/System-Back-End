package com.carlos2641.system.domain.model;

import com.carlos2641.system.infrastructure.out.persistence.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Long id_user;
    private String email;
    private String username;
    private String password;
    private Role role;

}
