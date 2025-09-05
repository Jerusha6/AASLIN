package com.aaslin.JobPortal.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private AuthRepository authRepo;
    private PasswordEncoder passwordEncoder;

    public DataInitializer(AuthRepository authRepo, PasswordEncoder passwordEncoder) {
        this.authRepo = authRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authRepo.findById("jerusha.aaslin@example.com").isEmpty()) {
            RegisterUser admin = RegisterUser.builder()
                .email("jerusha.aaslin@example.com")
                .firstName("Jerusha")
                .lastName("Rani")
                .passwordHash(passwordEncoder.encode("admin"))
                .role("ADMIN")
                .isActive(true)
                .build();

            authRepo.save(admin);
            System.out.println("Admin user created!");
        }
    }
}
