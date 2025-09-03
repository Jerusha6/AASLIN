package com.aaslin.JobPortal.JobPosts;

import com.aaslin.JobPortal.Applications.JobApplication;
import com.aaslin.JobPortal.userProfile.model.SavedJob;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Autowired
    CustomIDGenerator generator;

    @Id
    private String id;
    @PrePersist
    public void generateId() {
        if (id == null) {
            id = generator.generateCustomId("JOBID");  //change later
        }
    }

    @Column(length = 200)
    private String title;

    private String description;

    @Column(length = 200)
    private String location;  //location of our company

//    private String CTC;

    private String experienceRequired;

    private Set<String> skillsRequired;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean isActive = Boolean.TRUE;

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
    private Set<JobApplication> applications;

    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
    private Set<SavedJob> savedJobs;
}
