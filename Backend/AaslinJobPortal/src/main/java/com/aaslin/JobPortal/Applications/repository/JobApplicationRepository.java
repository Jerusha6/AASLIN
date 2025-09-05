package com.aaslin.JobPortal.Applications.repository;

import com.aaslin.JobPortal.Applications.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, String> {
    List<JobApplication> findByJobPostId(String jobPostId);
}
