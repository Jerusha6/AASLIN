package com.aaslin.JobPortal.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OTPGenerator {
    public String generateOTP(){
        int size = 6;
            StringBuilder otp = new StringBuilder();
            Random random = new Random();
            for (int iteration = 0; iteration < size; iteration++) {
                otp.append(random.nextInt(10));
            }
            return otp.toString();
    }
}
