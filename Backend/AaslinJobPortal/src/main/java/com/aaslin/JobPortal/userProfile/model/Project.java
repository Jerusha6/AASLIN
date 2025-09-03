package com.aaslin.JobPortal.userProfile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String projectName;
    private String projectDescription;
    private int durationInMonths;
    private String projectLink; //if available
}
