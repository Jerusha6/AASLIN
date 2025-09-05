package com.aaslin.JobPortal.userProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;

public interface UserRepository extends JpaRepository<JobSeekerProfile, String> {
}
