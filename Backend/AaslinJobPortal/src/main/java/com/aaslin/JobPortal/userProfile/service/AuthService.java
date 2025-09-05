package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;
    
    public ResponseEntity<String> registerUser(RegisterUser request){
    	if (authRepo.existsById(request.getEmail())) {
            return ResponseEntity.badRequest().body("User already exists with email: " + request.getEmail());
        }
    	request.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));
        authRepo.save(request);
        return ResponseEntity.ok("User registered successfully");
    }
    
    public void verifyEmail(@RequestParam String receiptEmail){
        mailService.sendSimpleEmail(receiptEmail);
    }

    public boolean checkCredentials(String email, String password) {
        Optional<RegisterUser> userOptional = authRepo.findById(email);
        if (userOptional.isPresent()) {
            return passwordEncoder.matches(password, userOptional.get().getPasswordHash());
        }
        return false;
    }


	public boolean checkUser(String email) {
		return authRepo.existsById(email);
	}
}
