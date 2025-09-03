package com.aaslin.JobPortal.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "profile")
@Entity
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "jobseeker_email",
        referencedColumnName = "user_email",
        nullable = false
    )
    private JobSeekerProfile profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", length = 32, nullable = false)
    private EducationLevel level;

    @Column(name = "institute_name", length = 200, nullable = false)
    private String instituteName;

    @Column(length = 200)
    private String branch;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "score_type", length = 16)
    private ScoreType scoreType;

    @Column(name = "score_value", precision = 5, scale = 2)
    private BigDecimal scoreValue; // e.g., 8.80 (CGPA) or 85.80 (%)

    @Column(name = "score_scale", precision = 5, scale = 2)
    private BigDecimal scoreScale; 

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}