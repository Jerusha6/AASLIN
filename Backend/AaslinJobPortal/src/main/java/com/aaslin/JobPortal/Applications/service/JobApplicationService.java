package com.aaslin.JobPortal.Applications.service;

import java.util.List;

import com.aaslin.JobPortal.Applications.model.JobApplication;

public interface JobApplicationService {
	JobApplication submitApplication(JobApplication application);
	JobApplication getApplicationById(String applicationId);
	List<JobApplication> getApplicationForJobPost(String jobPostId);
	JobApplication updateApplicationStatus(String id, String status);
	void withdrawApplication(String id, String seekerEmail);
	

}
