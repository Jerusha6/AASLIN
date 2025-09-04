package com.aaslin.JobPortal.userProfile.service;

import org.springframework.stereotype.Service;

import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JobSeekerProfile getUserById(String email) {
        return userRepository.findById(email).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public JobSeekerProfile updateUser(String email, JobSeekerProfile user) {
        JobSeekerProfile existingUser = getUserById(email);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}