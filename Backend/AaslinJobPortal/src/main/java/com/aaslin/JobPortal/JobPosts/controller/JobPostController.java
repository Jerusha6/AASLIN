package com.aaslin.JobPortal.JobPosts.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.JobPosts.service.JobPostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class JobPostController {

	private final JobPostService jobPostService;
	@PostMapping("/admin/post-job")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost){
		return ResponseEntity.ok(jobPostService.createJobPost(jobPost));
	}
	
    @GetMapping("/job-posts")
    public ResponseEntity<List<JobPost>> getAllJobPosts() {
        return ResponseEntity.ok(jobPostService.getAllJobPosts());
    }
    @GetMapping("/job-posts/{id}")
    public ResponseEntity<JobPost> getJobPostById(@PathVariable String id) {
        return ResponseEntity.ok(jobPostService.getJobPostById(id));
    }

    @PutMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<JobPost> updateJobPost(@PathVariable String id, @RequestBody JobPost jobPost) {
        return ResponseEntity.ok(jobPostService.updateJobPost(id, jobPost));
    }
}
