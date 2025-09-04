package com.aaslin.JobPortal.userProfile.repository;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, String> {
    boolean existsByEmail(String email);
}