package com.aaslin.JobPortal.JobPosts.model;

import com.aaslin.JobPortal.Applications.model.JobApplication;
import com.aaslin.JobPortal.userProfile.model.SavedJob;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Autowired
    @Transient
    private CustomIDGenerator generator;

    @Id
    @Column(name = "job_post_id", length = 50)
    private String id;

    @PrePersist
    public void generateId() {
        if (id == null) {
            id = generator.generateCustomId("JOBID");
        }
    }

    @Column(length = 200, nullable = false)
    private String title;

    @Lob
    private String description;

    @Column(length = 200)
    private String location;

    private String experienceRequired;

    @ElementCollection
    @CollectionTable(name = "jobpost_skills", joinColumns = @JoinColumn(name = "job_post_id"))
    @Column(name = "skill")
    private Set<String> skillsRequired;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean isActive = Boolean.TRUE;

    @OneToMany(mappedBy = "jobPost")
    private Set<JobApplication> applications;

    @OneToMany(mappedBy = "jobPost")
    private Set<SavedJob> savedJobs;
}