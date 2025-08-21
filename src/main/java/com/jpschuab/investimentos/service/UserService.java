package com.jpschuab.investimentos.service;

import com.jpschuab.investimentos.controller.CreateUserDto;
import com.jpschuab.investimentos.entity.User;
import com.jpschuab.investimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        var entity = new User();
        entity.setUsername(createUserDto.username());
        entity.setEmail(createUserDto.email());
        entity.setPassword(createUserDto.password());

        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }
}
