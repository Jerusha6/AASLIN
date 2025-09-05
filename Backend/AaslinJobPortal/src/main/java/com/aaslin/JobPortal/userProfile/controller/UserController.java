package com.aaslin.JobPortal.userProfile.controller;

import org.springframework.web.bind.annotation.*;
import com.aaslin.JobPortal.userProfile.model.JobSeekerProfile;
import com.aaslin.JobPortal.userProfile.service.UserService;

@RestController
@RequestMapping("/careers/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public JobSeekerProfile getUserById(@RequestParam String email) {
        return userService.getUserById(email);
    }

    @PutMapping
    public JobSeekerProfile updateUser(@RequestParam String email, @RequestBody JobSeekerProfile jobSeekerProfile) {
        return userService.updateUser(email, jobSeekerProfile);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return "User Deleted Successfully!";
    }
}