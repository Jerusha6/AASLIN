package com.aaslin.JobPortal.userProfile.controller;

import com.aaslin.JobPortal.security.JwtService;
import com.aaslin.JobPortal.userProfile.model.AuthResponse;
import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.service.AuthService;
import com.aaslin.JobPortal.userProfile.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "http://localhost:4200") 
public class AuthController {

   

    @Autowired
    private AuthService service;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUser request) {
        return service.registerUser(request);
    }
    

    @GetMapping("/send-email-otp")
    public ResponseEntity<String> verifyEmail(@RequestParam String receiptEmail){
        service.verifyEmail(receiptEmail);
        return ResponseEntity.ok("Otp sent successfully");
    }
    
    @GetMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {   	
    	return ResponseEntity.ok(service.verifyOtp(email, otp));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        boolean valid = service.checkCredentials(email, password);

        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // Load UserDetails for JWT generation
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String jwtToken = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }


    @PostMapping("/logout")
    public ResponseEntity<String> endSession(){
    	return ResponseEntity.ok("Logged out successfully");
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
