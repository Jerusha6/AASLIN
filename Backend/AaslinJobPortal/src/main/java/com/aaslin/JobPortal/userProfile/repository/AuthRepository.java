package com.aaslin.JobPortal.userProfile.repository;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AuthRepository extends JpaRepository<RegisterUser, String> {
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO register_user(email) VALUES (?1)", nativeQuery = true)
    void insertEmail(String email);
}
