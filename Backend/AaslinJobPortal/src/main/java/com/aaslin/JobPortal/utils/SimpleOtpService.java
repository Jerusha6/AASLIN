package com.aaslin.JobPortal.utils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.security.SecureRandom;

@Service
public class SimpleOtpService {

    private final StringRedisTemplate redisTemplate;
    private final SecureRandom secureRandom = new SecureRandom();

    public SimpleOtpService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Generate OTP and store in Redis with 5 mins expiry
    public String generateOtp(String key) {
        String otp = generate6DigitOtp();
        redisTemplate.opsForValue().set(key, otp, Duration.ofMinutes(5));
        return otp;
    }

    // Verify OTP and delete from Redis if correct
    public boolean verifyOtp(String key, String submittedOtp) {
        String storedOtp = redisTemplate.opsForValue().get(key);

        if (storedOtp != null && storedOtp.equals(submittedOtp)) {
            redisTemplate.delete(key); // OTP used, remove it
            return true;
        }
        return false;
    }

    private String generate6DigitOtp() {
        int number = secureRandom.nextInt(900000) + 100000; // ensures 6 digits
        return String.valueOf(number);
    }
}
