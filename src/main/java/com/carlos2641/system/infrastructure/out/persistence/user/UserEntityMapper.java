package com.carlos2641.system.infrastructure.out.persistence.user;

import com.carlos2641.system.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
                null, user.getEmail(),
                user.getUsername(), user.getPassword(),
                user.getRole()
        );
    }

    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId_user(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole()
        );
    }

}
