package com.aaslin.JobPortal.utils;

import org.springframework.beans.factory.annotation.Autowired;

public class SendOtpImp implements SendOtpInterface{

    @Autowired
    OTPGenerator otp;
    @Override
    public String sendOtpToEmail(String email) {
        String holdOtp=otp.generateOTP();
        return holdOtp;
    }

    @Override
    public String sendOtpToSMS(String contact) {
        String holdOtp=otp.generateOTP();
        return holdOtp;
    }
}
