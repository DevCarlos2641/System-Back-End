package com.carlos2641.system.domain.port.in;

import com.carlos2641.system.domain.model.User;
import com.carlos2641.system.infrastructure.in.dto.RememberResponse;

import java.util.List;
import java.util.Optional;

public interface UserUseCase {
    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
}
