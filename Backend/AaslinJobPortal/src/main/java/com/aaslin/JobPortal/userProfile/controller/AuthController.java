package com.aaslin.JobPortal.userProfile.controller;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "http://localhost:4200") 
public class AuthController {

   

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUser request) {
        return service.registerUser(request);
    }
    

    @GetMapping("/send-email-otp")
    public void verifyEmail(@RequestParam String receiptEmail){
        service.verifyEmail(receiptEmail);
    }

    @GetMapping("/login")
    public ResponseEntity<String> validateUser(@RequestParam String email, @RequestParam String password){
    	boolean isUserExist = service.checkUser(email);
    	boolean isValid = service.checkCredentials(email, password);
    	if(isUserExist) {
    		if(isValid) {
        		return ResponseEntity.ok("Login successful");
        	}
        	else {
        		return ResponseEntity.ok("Login failed");
        	}
    	}
    	else {
    		return  ResponseEntity.ok("User not found");
    	}
    	
		
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