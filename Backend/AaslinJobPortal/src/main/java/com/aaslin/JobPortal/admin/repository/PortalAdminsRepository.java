package com.aaslin.JobPortal.admin.repository;

import com.aaslin.JobPortal.userProfile.model.PortalAdmins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortalAdminsRepository extends JpaRepository<PortalAdmins, String> {
    boolean existsByEmail(String email);
}