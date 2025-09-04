package com.aaslin.JobPortal.userProfile.service;

import com.aaslin.JobPortal.userProfile.model.RegisterUser;
import com.aaslin.JobPortal.userProfile.repository.RegisterUserRepository;
import com.aaslin.JobPortal.userProfile.repository.PortalAdminsRepository;
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

    private final RegisterUserRepository registerUserRepository;
    private final PortalAdminsRepository portalAdminsRepository;

    public CustomUserDetailsService(RegisterUserRepository registerUserRepository,
                                    PortalAdminsRepository portalAdminsRepository) {
        this.registerUserRepository = registerUserRepository;
        this.portalAdminsRepository = portalAdminsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisterUser user = registerUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        String role = portalAdminsRepository.existsByEmail(email) ? "Admin" : "JobSeeker";

        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        return new User(user.getEmail(), user.getPasswordHash(), Collections.singletonList(authority));
    }
}