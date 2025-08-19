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

    public void createUser(CreateUserDto createUserDto) {
        //Primeiro é necessário converter DTO -> Entity
        var entity = new User(UUID.randomUUID(), createUserDto.username(), createUserDto.email(), createUserDto.password(), Instant.now(), null);
        userRepository.save(entity);
    }
}
