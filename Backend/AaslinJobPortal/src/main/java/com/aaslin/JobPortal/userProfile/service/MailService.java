package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.utils.OTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    OTPGenerator otp;

    public void sendSimpleEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jerusha.aaslin@gmail.com"); //change this later to aaslin primary email
        message.setTo(to);
        message.setSubject("OTP Verification Mail");
        message.setText("Your OTP: "+otp.generateOTP());
        mailSender.send(message);
    }
}
