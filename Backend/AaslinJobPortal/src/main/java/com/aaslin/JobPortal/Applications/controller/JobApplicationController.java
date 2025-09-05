package com.aaslin.JobPortal.Applications.controller;

import com.aaslin.JobPortal.Applications.model.JobApplication;
import com.aaslin.JobPortal.Applications.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class JobApplicationController {

    private final JobApplicationService applicationService;
    @PostMapping("/applications")
    public ResponseEntity<JobApplication> submitApplication(@RequestBody JobApplication application) {
        JobApplication savedApp = applicationService.submitApplication(application);
        return ResponseEntity.ok(savedApp);
    }
    @GetMapping("/applications/id")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }
    @GetMapping("/job-posts/id/applications")
    public ResponseEntity<List<JobApplication>> getApplicationsForJobPost(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.getApplicationForJobPost(id));
    }

    @PutMapping("/applications/id")
    public ResponseEntity<JobApplication> updateApplicationStatus(@PathVariable String id,
                                                                  @RequestParam String status) {
        JobApplication updatedApp = applicationService.updateApplicationStatus(id, status);
        return ResponseEntity.ok(updatedApp);
    }
    @DeleteMapping("/applications/id")
    public ResponseEntity<String> withdrawApplication(@PathVariable String id,
                                                      @RequestParam String seekerEmail) {
        applicationService.withdrawApplication(id, seekerEmail);
        return ResponseEntity.ok("Application withdrawn successfully");
    }
}