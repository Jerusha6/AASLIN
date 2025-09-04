package com.aaslin.JobPortal.userProfile.model;

import com.aaslin.JobPortal.JobPosts.model.JobPost;
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
    @JoinColumn(name = "jobseeker_email", nullable = false)
    private JobSeekerProfile jobseekerProfile; //

    private LocalDate applicationDeadline;

    @UpdateTimestamp
    private LocalDateTime savedAt;
}