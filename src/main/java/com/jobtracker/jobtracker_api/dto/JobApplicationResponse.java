package com.jobtracker.jobtracker_api.dto;

import com.jobtracker.jobtracker_api.entity.ApplicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JobApplicationResponse {

    private Long id;
    private String company;
    private String jobTitle;
    private ApplicationStatus status;
    private String location;
    private BigDecimal salary;
    private LocalDate dateApplied;
    private String jobUrl;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public JobApplicationResponse() {
    }

    public JobApplicationResponse(
            Long id,
            String company,
            String jobTitle,
            ApplicationStatus status,
            String location,
            BigDecimal salary,
            LocalDate dateApplied,
            String jobUrl,
            String notes,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.status = status;
        this.location = location;
        this.salary = salary;
        this.dateApplied = dateApplied;
        this.jobUrl = jobUrl;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}