package com.aaslin.JobPortal.JobPosts.model;

import com.aaslin.JobPortal.Applications.model.JobApplication;
import com.aaslin.JobPortal.savedJob.model.SavedJob;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Transient
    private CustomIDGenerator generator;

    @Id
    @Column(name = "job_post_id", length = 50)
    private String id;

    @PrePersist
    public void generateId() {
        if (id == null && generator != null) {
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
    private Set<String> skillsRequired = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    private LocalDate applicationDeadline;

    private Boolean isActive = Boolean.TRUE;

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JobApplication> applications = new HashSet<>();

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SavedJob> savedJobs = new HashSet<>();
}
