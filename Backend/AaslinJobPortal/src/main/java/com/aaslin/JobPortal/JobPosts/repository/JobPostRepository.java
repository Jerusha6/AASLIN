package com.aaslin.JobPortal.JobPosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.JobPortal.JobPosts.model.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost,String>{
	
	

}
