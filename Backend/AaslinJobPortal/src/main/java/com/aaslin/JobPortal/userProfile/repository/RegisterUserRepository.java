package com.aaslin.JobPortal.userProfile.repository;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, String> {
    Optional<RegisterUser> findByEmail(String email);
    boolean existsByEmail(String email);
}