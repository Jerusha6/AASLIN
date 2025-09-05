package com.aaslin.JobPortal.savedJob.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aaslin.JobPortal.savedJob.model.SavedJob;
import com.aaslin.JobPortal.savedJob.service.SavedJobService;

@RestController
@RequestMapping("/careers/saved-jobs")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SavedJobController {

	private final SavedJobService savedJobService;
	
	@PostMapping("/{id}")
	public String saveJob(@PathVariable("id") String id, @RequestParam String email) {
		savedJobService.saveJob(id, email);
		return "Job saved Succesfully!";
	}
	
	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable("id") String id, @RequestParam String email) {
		savedJobService.removeJobByJobPostId(id, email);
		return "Job removed from Saved List.";
	}
	
	@GetMapping
	public List<SavedJob> allSavedJobs(@RequestParam String email) {
		return savedJobService.getAllSavedJobsByEmail(email);
	}
}