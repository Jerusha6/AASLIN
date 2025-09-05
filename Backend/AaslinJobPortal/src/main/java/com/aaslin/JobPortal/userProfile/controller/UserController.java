package com.aaslin.JobPortal.userProfile.controller;

import org.springframework.web.bind.annotation.*;

import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/careers/users")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public JobSeekerProfile getUserById(@RequestParam String email) {
        return userService.getUserById(email);
    }

    @PutMapping
    public String updateUser(@RequestParam String email, @RequestBody JobSeekerProfile jobSeekerProfile) {
        userService.updateUser(email, jobSeekerProfile);
        return "User details Updated Successfully!";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return "User Deleted Successfully!";
    }
}
