package com.aaslin.JobPortal.utils;

import org.springframework.stereotype.Component;

@Component
public class CustomIDGenerator {
    static int count = 1000;
    public static String generateCustomId(String prefix) {
        return prefix + String.format("%05d", count++);
    }
}
