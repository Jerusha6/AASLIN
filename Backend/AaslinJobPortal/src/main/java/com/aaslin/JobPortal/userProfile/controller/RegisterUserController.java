package com.aaslin.JobPortal.userProfile.controller;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.RegisterUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers/register")
@CrossOrigin(origins = "http://localhost:4200") 
public class RegisterUserController {

    @Autowired
    private RegisterUserRepository repository;

    @PostMapping
    public String registerUser(@RequestBody RegisterUser user) {
        if (repository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }
        repository.save(user);
        return "User registered successfully!";
    }
}