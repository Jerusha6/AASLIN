package com.aaslin.JobPortal.userProfile.controller;

import com.aaslin.JobPortal.security.JwtService;
import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;
import com.aaslin.JobPortal.userProfile.service.AuthService;
import com.aaslin.JobPortal.userProfile.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "http://localhost:4200") 
public class AuthController {

    @Autowired
    private MailService mailService;
    @Autowired
    private AuthRepository authRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser request) {
        if (authRepo.existsById(request.getEmail())) {
            return ResponseEntity.badRequest().body("User already exists with email: " + request.getEmail());
        }
        authRepo.save(request);
        return ResponseEntity.ok("User registered successfully");
    }
    

    @GetMapping("/send-otp")
    public void verifyEmail(@RequestParam String receiptEmail){
        mailService.sendSimpleEmail(receiptEmail);
    }

    @PostMapping("/login")
    public void validateUser(){

    }

    @PostMapping("/logout")
    public void endSession(){

    }

    @PostMapping("/forgot-password")
    public void forgotPasswordRedirect(){

    }

    @PostMapping("/reset-password")
    public void modifyPassword(){

    }

    @GetMapping("/profile")
    public void careersProfilePage(){

    }

    
}