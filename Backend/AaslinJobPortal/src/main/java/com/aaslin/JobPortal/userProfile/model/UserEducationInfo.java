package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEducationInfo {

    @Id
    @Column(name = "education_id", length = 50)
    private String id;

    private String qualification;

    private String instituteName;

    private String stream;

    private Integer graduationYear;

    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;

    @Column(name = "score_value", precision = 5, scale = 2)
    private BigDecimal scoreValue; // e.g., 8.80 (CGPA) or 85.80 (%)

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "email")
    private RegisterUser registerUser;
}