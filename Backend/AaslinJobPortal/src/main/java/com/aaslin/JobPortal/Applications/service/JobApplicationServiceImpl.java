package com.aaslin.JobPortal.Applications.service;

import com.aaslin.JobPortal.Applications.model.ApplicationStatus;
import com.aaslin.JobPortal.Applications.model.JobApplication;
import com.aaslin.JobPortal.Applications.repository.JobApplicationRepository;
import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.JobPosts.repository.JobPostRepository;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository applicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    @Override
    public JobApplication submitApplication(JobApplication application) {
        if(application == null) throw new RuntimeException("Application cannot be null");

        JobPost jobPost = jobPostRepository.findById(application.getJobPost().getId())
                .orElseThrow(() -> new RuntimeException("JobPost not found"));

        JobSeekerProfile seeker = userRepository.findById(application.getJobseekerProfile().getEmail())
                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));

        application.setJobPost(jobPost);
        application.setJobseekerProfile(seeker);
        application.setStatus(ApplicationStatus.PENDING);

        return applicationRepository.save(application);
    }

    @Override
    public JobApplication getApplicationById(String applicationId) {
        return applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found: " + applicationId));
    }

    @Override
    public List<JobApplication> getApplicationForJobPost(String jobPostId) {
        jobPostRepository.findById(jobPostId)
                .orElseThrow(() -> new RuntimeException("JobPost not found: " + jobPostId));
        return applicationRepository.findByJobPostId(jobPostId);
    }

    @Override
    public JobApplication updateApplicationStatus(String id, String status) {
        JobApplication application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found: " + id));

        try {
            ApplicationStatus newStatus = ApplicationStatus.valueOf(status.toUpperCase());
            application.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid application status: " + status);
        }

        return applicationRepository.save(application);
    }

    @Override
    public void withdrawApplication(String id, String seekerEmail) {
        JobApplication application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found: " + id));

        if (!application.getJobseekerProfile().getEmail().equals(seekerEmail)) {
            throw new RuntimeException("Unauthorized: You can only withdraw your own application");
        }

        applicationRepository.delete(application);
    }
}
