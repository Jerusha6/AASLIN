package com.aaslin.JobPortal.Applications.model;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.model.UserEducationInfo;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplication {

    @Transient
    private CustomIDGenerator generator;

    @Id
    @Column(name = "application_id", length = 50)
    private String applicationId;

    @PrePersist
    public void generateId() {
        if (applicationId == null && generator != null) {
            applicationId = generator.generateCustomId("APPID");
        }
    }

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(length = 200)
    private String linkedin;

    @Column(length = 200)
    private String github;

    @Lob
    private byte[] resume;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private UserEducationInfo educationalDetails;

    private LocalDateTime appliedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "job_post_id", nullable = false)
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "jobseeker_email", nullable = false)
    private JobSeekerProfile jobseekerProfile;
}