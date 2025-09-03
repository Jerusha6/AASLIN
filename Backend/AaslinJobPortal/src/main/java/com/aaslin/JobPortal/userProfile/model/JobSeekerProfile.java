package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import com.aaslin.JobPortal.Applications.JobApplication;
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
    private boolean workingStatus;
    private Integer yearsOfExperience;

    @ElementCollection
    @CollectionTable(name = "jobseeker_languages", joinColumns = @JoinColumn(name = "email"))
    @Column(name = "language")
    private Set<String> languages;

    private Double currentCTC;
    private Double expectedSalary;

    @Lob
    private byte[] resume;
    private String resumeFileName;

    @ElementCollection
    @CollectionTable(name = "jobseeker_projects", joinColumns = @JoinColumn(name = "email"))
    private Set<Project> project;

    @ElementCollection
    @CollectionTable(name = "jobseeker_internship", joinColumns = @JoinColumn(name = "email"))
    private Set<Internship> internships;

    @OneToOne(mappedBy = "jobSeekerProfile")
    private UserPersonalInfo userPersonalInfo;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "jobseeker_education",
        joinColumns = @JoinColumn(name = "jobseeker_email"),
        inverseJoinColumns = @JoinColumn(name = "education_email")
    )
    private Set<UserEducationInfo> userEducationInfo;

    @OneToMany(mappedBy = "jobseekerProfile")
    private Set<JobApplication> applications;

    @OneToMany(mappedBy = "jobseekerProfile")
    private Set<SavedJob> savedJobs;
}