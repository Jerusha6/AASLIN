package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthRepository repository;
    public String registerUser(RegisterUser user){
        repository.save(user);
        return "user saved";
    }
}
