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
    @MapsId
    @JoinColumn(name = "email")
    private RegisterUser registerUser;

    private String bio;

    private String currentOrganization;

    private boolean workingStatus; //checkbox states currently working here or not

    private Integer yearsOfExperience;

    private Set<String> languages;

    private Double currentCTC; // if they want to mention

    private Double expectedSalary; //placeholder should be there in form saying (in LPA)

    @Lob
    private byte[] resume;

    private String resumeFileName;

    private Set<Project> project;

    private Set<Internship> internships;

    @OneToMany(mappedBy = "jobseekerProfile", cascade = CascadeType.ALL)
    private Set<UserEducationInfo> userEducationInfo;
}
