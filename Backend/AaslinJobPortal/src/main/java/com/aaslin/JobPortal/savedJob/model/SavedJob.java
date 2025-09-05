package com.aaslin.JobPortal.savedJob.model;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.utils.CustomIDGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SavedJob {

    @Id
    @Column(name = "saved_job_id", length = 50)
    private String id;

    @ManyToOne
    @JoinColumn(name = "job_post_id", nullable = false)
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "job_seeker_email", nullable = false)
    private JobSeekerProfile jobseekerProfile;

    private LocalDate applicationDeadline;

    @UpdateTimestamp
    private LocalDateTime savedAt;

    @Transient
    private CustomIDGenerator generator;

    @PrePersist
    public void prePersist() {
        if (id == null && generator != null) {
            id = generator.generateCustomId("SAVEDJOB");
        }
    }
}
