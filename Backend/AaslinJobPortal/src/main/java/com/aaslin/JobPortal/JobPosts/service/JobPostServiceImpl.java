package com.aaslin.JobPortal.JobPosts.service;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.JobPosts.repository.JobPostRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository jobPostRepository;

    @Override
    public JobPost createJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @Override
    public JobPost getJobPostById(String id) {
        return jobPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job post not found with id: " + id));
    }

    @Override
    public JobPost updateJobPost(String id, JobPost jobPost) {
        JobPost existingJobPost = jobPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job post not found with id: " + id));

        existingJobPost.setTitle(jobPost.getTitle());
        existingJobPost.setDescription(jobPost.getDescription());
        existingJobPost.setLocation(jobPost.getLocation());
        existingJobPost.setExperienceRequired(jobPost.getExperienceRequired());
        existingJobPost.setSkillsRequired(jobPost.getSkillsRequired());
        existingJobPost.setIsActive(jobPost.getIsActive());

        return jobPostRepository.save(existingJobPost);
    }

    @Override
    public void deleteJobPost(String id) {
        if (!jobPostRepository.existsById(id)) {
            throw new RuntimeException("Job post is not found with id: " + id);
        }
        jobPostRepository.deleteById(id);
    }
}