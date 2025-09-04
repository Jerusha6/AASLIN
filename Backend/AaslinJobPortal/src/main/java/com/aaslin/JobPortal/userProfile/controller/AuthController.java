package com.aaslin.JobPortal.userProfile.controller;

import com.aaslin.JobPortal.userProfile.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "http://localhost:4200") 
public class AuthController {

    @Autowired
    private MailService mailService;

    @PostMapping("/register")
    public void registerUser(){

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