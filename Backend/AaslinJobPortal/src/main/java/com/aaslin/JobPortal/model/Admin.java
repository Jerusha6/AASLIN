package com.aaslin.JobPortal.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "user")
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "user_email", length = 100, nullable = false)
    private String userEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", referencedColumnName = "email", insertable = false, updatable = false)
    private RegisterUser user;

    @Column(length = 100)
    private String role;

    @Lob
    private String permissions;
}
