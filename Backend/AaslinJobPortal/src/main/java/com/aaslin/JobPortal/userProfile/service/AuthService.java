package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;
import com.aaslin.JobPortal.utils.SimpleOtpService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private SimpleOtpService otpService;
    
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
        Optional<RegisterUser> user = authRepo.findById(email);
        if (user.isPresent()) {
            return passwordEncoder.matches(password, user.get().getPasswordHash());
        }
        return false;
    }


	public boolean checkUser(String email) {
		return authRepo.existsById(email);
	}

    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = otpService.verifyOtp(email, otp);
        return valid ? "OTP verified successfully." : "Invalid or expired OTP.";
    }

	public ResponseEntity<String> resetPassword(String email, String password) {
		
		Optional<RegisterUser> user = authRepo.findById(email);
        if (user.isPresent()) {
        	if(passwordEncoder.matches(user.get().getPasswordHash(), password)) {
        		return ResponseEntity.ok("Password must not be same as previous");
        	}
        	else {
        		 user.get().setPasswordHash(passwordEncoder.encode(password));
        		 return ResponseEntity.ok("Password modified successfully");
        	}
           
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		
		
	}


}
