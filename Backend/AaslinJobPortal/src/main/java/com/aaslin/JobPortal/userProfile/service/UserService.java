package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;

public interface UserService {
    JobSeekerProfile getUserById(String email);
    JobSeekerProfile updateUser(String email, JobSeekerProfile jobSeekerProfile);
    void deleteUser(String email);
}