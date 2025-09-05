package com.aaslin.JobPortal.userProfile.service;

import org.springframework.stereotype.Service;

import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Override
    public JobSeekerProfile getUserById(String email) {
        return userRepository.findById(email).orElseThrow(() -> new RuntimeException("User Not Found!"));
    }

    @Override
    public JobSeekerProfile updateUser(String email, JobSeekerProfile jobSeekerProfile) {
    	userRepository.findById(email).orElseThrow(() -> new RuntimeException("User Not Found!"));
        return userRepository.save(jobSeekerProfile);
    }

    @Override
    public void deleteUser(String email) {
    	userRepository.findById(email).orElseThrow(() -> new RuntimeException("User Not Found!"));
        userRepository.deleteById(email);
    }
}
