package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobSeekerProfile {

    @Id
    private String email;

    @OneToOne
    @JoinColumn(name = "email", insertable = false, updatable = false)
    private RegisterUser registerUser;

    private String bio;
    private String currentOrganization;
    private boolean workingStatus; //checkbox states currently working here or not
    private Integer yearsOfExperience;

    @ElementCollection
    @CollectionTable(name = "jobseeker_languages", joinColumns = @JoinColumn(name = "email"))
    @Column(name = "language")
    private Set<String> languages;

    private Double currentCTC; // if they want to mention
    private Double expectedSalary; //placeholder should be there in form saying (in LPA)

    @Lob
    private byte[] resume;
    private String resumeFileName;

    @ElementCollection
    @CollectionTable(name = "jobseeker_projects", joinColumns = @JoinColumn(name = "email"))
    private Set<Project> project;

    @Transient
    private Set<Internship> internships;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "jobseeker_education",
        joinColumns = @JoinColumn(name = "jobseeker_email"),
        inverseJoinColumns = @JoinColumn(name = "education_email")
    )
    private Set<UserEducationInfo> userEducationInfo;
}
