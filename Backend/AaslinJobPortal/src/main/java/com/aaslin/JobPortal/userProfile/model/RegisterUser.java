package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegisterUser {

    @Id
    @Column(name="email", nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "password_hash", length = 255, nullable = false)
    private String passwordHash;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "registerUser")
    private UserEducationInfo userEducationInfo;

    @OneToOne(mappedBy = "registerUser")
    private JobSeekerProfile jobSeekerProfile;

    @OneToOne(mappedBy = "registerUser")
    private UserPersonalInfo userPersonalInfo;

	
}