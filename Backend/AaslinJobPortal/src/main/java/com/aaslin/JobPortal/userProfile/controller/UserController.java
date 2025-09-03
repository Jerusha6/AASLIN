package com.aaslin.JobPortal.userProfile.controller;

import org.springframework.web.bind.annotation.*;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/careers/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public JobSeekerProfile getUserById(@PathVariable String email) {
        return userService.getUserById(email);
    }

    @PutMapping("{/id}")
    public JobSeekerProfile updateUser(@PathVariable String email, @PathVariable JobSeekerProfile jobSeekerProfile) {
        return userService.updateUser(email, jobSeekerProfile);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return "User Deleted Successfully!";
    }

    @GetMapping()
    public List<JobSeekerProfile> getAllUsers() {
        return userService.getAllUsers();
    }
}