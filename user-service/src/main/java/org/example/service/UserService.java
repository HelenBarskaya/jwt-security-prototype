package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    public User save(User user){
        user.setId(UUID.randomUUID().toString());
        user.setRole("USER");
        return user;
    }
}
