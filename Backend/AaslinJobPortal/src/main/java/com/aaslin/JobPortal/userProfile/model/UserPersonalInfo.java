package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserPersonalInfo {

    @Id
    private String email;

    private String fatherName;

    private String gender;

    private LocalDate dob;

    private String city;

    private String state;

    private String country;

    private String pincode;

    private String nationality;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "email")
    private RegisterUser registerUser;

    @OneToOne
    @JoinColumn(name = "jobseeker_email", referencedColumnName = "email")
    private JobSeekerProfile jobSeekerProfile;
}
