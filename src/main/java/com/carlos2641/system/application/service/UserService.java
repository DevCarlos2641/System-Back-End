package com.carlos2641.system.application.service;

import com.carlos2641.system.domain.model.User;
import com.carlos2641.system.domain.port.in.UserUseCase;
import com.carlos2641.system.domain.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserUseCase {

    private final UserRepositoryPort repositoryPort;

    @Override
    public List<User> findAll() {
        return repositoryPort.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }
}
