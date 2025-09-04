package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.admin.repository.PortalAdminsRepository;
import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final AuthRepository authRepository;
    private final PortalAdminsRepository portalAdminsRepository;

    public CustomUserDetailsService(AuthRepository authRepository,
                                    PortalAdminsRepository portalAdminsRepository) {
        this.authRepository = authRepository;
        this.portalAdminsRepository = portalAdminsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisterUser user = authRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        String role = portalAdminsRepository.existsByEmail(email) ? "Admin" : "JobSeeker";

        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        return new User(user.getEmail(), user.getPasswordHash(), Collections.singletonList(authority));
    }
}