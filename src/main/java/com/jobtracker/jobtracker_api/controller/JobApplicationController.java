package com.jobtracker.jobtracker_api.controller;

import com.jobtracker.jobtracker_api.dto.JobApplicationRequest;
import com.jobtracker.jobtracker_api.dto.JobApplicationResponse;
import com.jobtracker.jobtracker_api.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping
    public List<JobApplicationResponse> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public JobApplicationResponse getApplicationById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplicationResponse createApplication(@Valid @RequestBody JobApplicationRequest request) {
        return jobApplicationService.createApplication(request);
    }

    @PutMapping("/{id}")
    public JobApplicationResponse updateApplication(@PathVariable Long id,
                                                    @Valid @RequestBody JobApplicationRequest request) {
        return jobApplicationService.updateApplication(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
    }
}