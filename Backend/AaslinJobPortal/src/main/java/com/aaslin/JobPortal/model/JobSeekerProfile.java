package com.aaslin.JobPortal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"user", "skills", "resume"})
@Entity
@Table(name = "jobseeker_profiles")
public class JobSeekerProfile {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "user_email", length = 100, nullable = false)
    private String userEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;

    @Lob
    private String bio;

    @Lob
    private String education;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @ElementCollection(targetClass = Skills.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "jobseeker_skills",
            joinColumns = @JoinColumn(name = "user_email")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "skill", length = 50)
    private Set<Skills> skills;

    @Column(name = "expected_salary", length = 50)
    private String expectedSalary;

    @Lob
    private byte[] resume;
}
