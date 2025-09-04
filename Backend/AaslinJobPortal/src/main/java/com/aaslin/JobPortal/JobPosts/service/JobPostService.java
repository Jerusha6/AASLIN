package com.aaslin.JobPortal.JobPosts.service;

import java.util.List;

import com.aaslin.JobPortal.JobPosts.model.JobPost;

public interface JobPostService {
	
	JobPost createJobPost(JobPost jobPost);
	List<JobPost> getAllJobPosts();
	JobPost getJobPostById(String id);
	JobPost updateJobPost(String id,JobPost jobPost);
	void deleteJobPost(String id);

}
