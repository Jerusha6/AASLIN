package com.aaslin.JobPortal.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"jobPost", "jobseekerProfile"})
@Entity
@Table(name = "applications")
public class Application {

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ApplicationKey implements Serializable {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@SuppressWarnings("unused")
		private Long jobPostId;
        @SuppressWarnings("unused")
		private String jobseekerEmail;
    }

    @EmbeddedId
    private ApplicationKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobPostId")
    @JoinColumn(name = "job_post_id", referencedColumnName = "job_post_id")
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobseekerEmail")
    @JoinColumn(name = "jobseeker_email", referencedColumnName = "user_email")
    private JobSeekerProfile jobseekerProfile;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(length = 200)
    private String linkedin;

    @Column(length = 200)
    private String github;

    @Lob
    private byte[] resume;

    @Lob
    private String educationalDetails;
}
