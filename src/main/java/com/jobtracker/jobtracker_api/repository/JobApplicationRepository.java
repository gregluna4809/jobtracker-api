package com.jobtracker.jobtracker_api.repository;

import com.jobtracker.jobtracker_api.entity.ApplicationStatus;
import com.jobtracker.jobtracker_api.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);
    List<JobApplication> findByCompanyContainingIgnoreCase(String keyword);
}