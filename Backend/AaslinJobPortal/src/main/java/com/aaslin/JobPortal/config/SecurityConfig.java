package com.aaslin.JobPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//	private final JwtAuthenticationFilter jwtAuthFilter;
//	//private final CustomerDetailsService customerDetailsService;
//	
//	@Bean
//	private SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http.csrf(csrf->csrf.disable())
//		.authorizeHttpRequests(auth->auth.requestMatchers("/careers/auth/register","/careers/auth/login",
//				"/careers/auth/logout","/auth/forgot-password","/auth/reset-password","/auth/profile")
//				.permitAll().requestMatchers("/careers/admin/**").hasAuthority("ADMIN"))
//	} 
//}
