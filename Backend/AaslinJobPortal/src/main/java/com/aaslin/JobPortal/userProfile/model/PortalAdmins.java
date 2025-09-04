package com.aaslin.JobPortal.userProfile.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PortalAdmins {

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String role;

}
