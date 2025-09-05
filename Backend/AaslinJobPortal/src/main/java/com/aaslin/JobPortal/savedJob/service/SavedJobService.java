package com.aaslin.JobPortal.savedJob.service;

import java.util.List;

import com.aaslin.JobPortal.savedJob.model.SavedJob;

public interface SavedJobService {

	SavedJob saveJob(String id, String email);
	void removeJobByJobPostId(String id, String email);
	List<SavedJob> getAllSavedJobsByEmail(String email);
}