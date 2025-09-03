package com.aaslin.JobPortal.Applications;


import com.aaslin.JobPortal.JobPosts.JobPost;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.model.UserEducationInfo;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplication {

    @Autowired
    CustomIDGenerator generator;

    @Id
    private String applicationId;
    @PrePersist
    public void generateId() {
        if (applicationId == null) {
            applicationId = generator.generateCustomId("APPID");  //change later
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

    private UserEducationInfo educationalDetails;

    private LocalDateTime appliedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "jobseeker_email")
    private JobSeekerProfile jobseekerProfile;
}
