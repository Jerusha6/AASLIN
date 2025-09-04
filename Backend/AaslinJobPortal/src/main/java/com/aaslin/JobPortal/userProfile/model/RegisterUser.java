package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class RegisterUser {

    @Id   
    private String email;
      
    private String firstName;

    private String lastName;
   
    private String passwordHash;
   
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean isActive;
    
    @Builder.Default
    private String role="JOBSEEKER"; //Defaultly assigning jobseeker as role to a new user.

    @OneToOne(mappedBy = "registerUser")
    private UserEducationInfo userEducationInfo;

    @OneToOne(mappedBy = "registerUser")
    private JobSeekerProfile jobSeekerProfile;

    @OneToOne(mappedBy = "registerUser")
    private UserPersonalInfo userPersonalInfo;

	
}
