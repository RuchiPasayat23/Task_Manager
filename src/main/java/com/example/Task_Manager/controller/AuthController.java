package com.example.Task_Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Task_Manager.model.User;
import com.example.Task_Manager.repository.UserRepository;
import com.example.Task_Manager.util.TokenUtil;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    // REGISTER USER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    // LOGIN USER
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> existingUser = userRepo.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername())
                        && u.getPassword().equals(user.getPassword()))
                .findFirst();

        if (existingUser.isPresent()) {
            return TokenUtil.generateToken(user.getUsername());
        } else {
            return "Invalid username or password";
        }
    }
}