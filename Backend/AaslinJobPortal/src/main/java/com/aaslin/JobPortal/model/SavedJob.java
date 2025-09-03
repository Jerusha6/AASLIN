package com.aaslin.JobPortal.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"jobPost", "saver"})
@Entity
@Table(name = "saved_jobs")
public class SavedJob {

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class SavedJobKey implements Serializable {
        private Long jobPostId;
        private String saverEmail;
    }

    @EmbeddedId
    private SavedJobKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("jobPostId")
    @JoinColumn(name = "job_post_id", referencedColumnName = "job_post_id")
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("saverEmail")
    @JoinColumn(name = "saver_email", referencedColumnName = "email")
    private User saver;

    @Column(name = "saved_at")
    private LocalDateTime savedAt = LocalDateTime.now();
}
