package com.carlos2641.system.infrastructure.out.persistence.user;

import com.carlos2641.system.domain.model.User;
import com.carlos2641.system.domain.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper mapper;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream().map(mapper::toDomain).toList();
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
