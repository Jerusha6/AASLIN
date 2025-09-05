package com.aaslin.JobPortal.savedJob.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aaslin.JobPortal.savedJob.model.SavedJob;

public interface SavedJobRepository extends JpaRepository<SavedJob, String> {
	Optional<SavedJob> findByJobPostIdAndJobseekerProfileEmail(String id, String email);
	List<SavedJob> findAllByJobseekerProfileEmail(String email);
}