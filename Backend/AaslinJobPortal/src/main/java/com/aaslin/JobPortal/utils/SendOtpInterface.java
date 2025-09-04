package com.aaslin.JobPortal.utils;
public interface SendOtpInterface {
    public String sendOtpToEmail(String email);
    public String sendOtpToSMS(String contact);
}
