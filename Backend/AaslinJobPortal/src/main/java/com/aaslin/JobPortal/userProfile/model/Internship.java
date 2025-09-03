package com.aaslin.JobPortal.userProfile.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Internship {
    private String internshipDomain;
    private String companyName;
    private int DurationInMonths;
    private String internshipDescription;
    private String role;
    private String projectName;
    private Set<String> skills;
    private String projectLink; //if available
}
