package com.aaslin.JobPortal.userProfile.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserPersonalInfo {

    @Id
    private String email;

    private String FatherName;

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
}
