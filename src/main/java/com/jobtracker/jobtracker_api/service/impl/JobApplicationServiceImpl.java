package com.jobtracker.jobtracker_api.service.impl;

import com.jobtracker.jobtracker_api.dto.JobApplicationRequest;
import com.jobtracker.jobtracker_api.dto.JobApplicationResponse;
import com.jobtracker.jobtracker_api.entity.JobApplication;
import com.jobtracker.jobtracker_api.exception.ResourceNotFoundException;
import com.jobtracker.jobtracker_api.repository.JobApplicationRepository;
import com.jobtracker.jobtracker_api.service.JobApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public List<JobApplicationResponse> getAllApplications() {
        return jobApplicationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public JobApplicationResponse getApplicationById(Long id) {
        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job application not found with id: " + id));

        return mapToResponse(application);
    }

    @Override
    public JobApplicationResponse createApplication(JobApplicationRequest request) {
        JobApplication application = new JobApplication();
        mapRequestToEntity(request, application);

        JobApplication saved = jobApplicationRepository.save(application);
        return mapToResponse(saved);
    }

    @Override
    public JobApplicationResponse updateApplication(Long id, JobApplicationRequest request) {
        JobApplication existingApplication = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job application not found with id: " + id));

        mapRequestToEntity(request, existingApplication);

        JobApplication updated = jobApplicationRepository.save(existingApplication);
        return mapToResponse(updated);
    }

    @Override
    public void deleteApplication(Long id) {
        JobApplication existingApplication = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job application not found with id: " + id));

        jobApplicationRepository.delete(existingApplication);
    }

    private void mapRequestToEntity(JobApplicationRequest request, JobApplication application) {
        application.setCompany(request.getCompany());
        application.setJobTitle(request.getJobTitle());
        application.setStatus(request.getStatus());
        application.setLocation(request.getLocation());
        application.setSalary(request.getSalary());
        application.setDateApplied(request.getDateApplied());
        application.setJobUrl(request.getJobUrl());
        application.setNotes(request.getNotes());
    }

    private JobApplicationResponse mapToResponse(JobApplication application) {
        return new JobApplicationResponse(
                application.getId(),
                application.getCompany(),
                application.getJobTitle(),
                application.getStatus(),
                application.getLocation(),
                application.getSalary(),
                application.getDateApplied(),
                application.getJobUrl(),
                application.getNotes(),
                application.getCreatedAt(),
                application.getUpdatedAt()
        );
    }
}