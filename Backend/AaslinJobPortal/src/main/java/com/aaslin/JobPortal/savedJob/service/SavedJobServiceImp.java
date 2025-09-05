package com.aaslin.JobPortal.savedJob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.JobPosts.service.JobPostService;
import com.aaslin.JobPortal.savedJob.model.SavedJob;
import com.aaslin.JobPortal.savedJob.repository.SavedJobRepository;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavedJobServiceImp implements SavedJobService {
	
	private final JobPostService jobPostService;
	private final UserService userService;
	private final SavedJobRepository savedJobRepository;
	
	@Override
	public SavedJob saveJob(String id, String email) {
		JobPost jobPost = jobPostService.getJobPostById(id);
		JobSeekerProfile jobSeekerProfile = userService.getUserById(email);
		SavedJob savedJob = new SavedJob();
		savedJob.setJobPost(jobPost);
		savedJob.setJobseekerProfile(jobSeekerProfile);
		savedJob.setApplicationDeadline(jobPost.getApplicationDeadline());
		return savedJobRepository.save(savedJob);
	}
	
	public void removeJobByJobPostId(String id, String email) {
	    Optional<SavedJob> savedJob = savedJobRepository.findByJobPostIdAndJobseekerProfileEmail(id, email);
	    SavedJob job = savedJob.orElseThrow(() -> new RuntimeException("Job Not Found in Saved Jobs."));
	    savedJobRepository.delete(job);
	}


	@Override
	public List<SavedJob> getAllSavedJobsByEmail(String email) {
		return savedJobRepository.findAllByJobseekerProfileEmail(email);
	}
}