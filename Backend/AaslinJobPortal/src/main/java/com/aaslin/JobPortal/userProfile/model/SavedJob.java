package com.aaslin.JobPortal.userProfile.model;

import com.aaslin.JobPortal.JobPosts.JobPost;
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
    private String id;

	@ManyToOne
	@MapsId
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;

    private LocalDate applicationDeadline;

    @UpdateTimestamp
    private LocalDateTime savedAt;
}
