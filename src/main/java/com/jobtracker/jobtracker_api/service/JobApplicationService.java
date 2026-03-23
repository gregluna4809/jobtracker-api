package com.jobtracker.jobtracker_api.service;

import com.jobtracker.jobtracker_api.dto.JobApplicationRequest;
import com.jobtracker.jobtracker_api.dto.JobApplicationResponse;

import java.util.List;

public interface JobApplicationService {

    List<JobApplicationResponse> getAllApplications();

    JobApplicationResponse getApplicationById(Long id);

    JobApplicationResponse createApplication(JobApplicationRequest request);

    JobApplicationResponse updateApplication(Long id, JobApplicationRequest request);

    void deleteApplication(Long id);
}