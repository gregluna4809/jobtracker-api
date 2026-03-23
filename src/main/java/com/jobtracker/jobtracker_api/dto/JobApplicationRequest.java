package com.jobtracker.jobtracker_api.dto;

import com.jobtracker.jobtracker_api.entity.ApplicationStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class JobApplicationRequest {

    @NotNull(message = "Company is required")
    @Size(min = 1, max = 150, message = "Company must be between 1 and 150 characters")
    private String company;

    @NotNull(message = "Job title is required")
    @Size(min = 1, max = 150, message = "Job title must be between 1 and 150 characters")
    private String jobTitle;

    @NotNull(message = "Status is required")
    private ApplicationStatus status;

    @Size(max = 150, message = "Location must be at most 150 characters")
    private String location;

    @DecimalMin(value = "0.0", inclusive = true, message = "Salary must be greater than or equal to 0")
    private BigDecimal salary;

    @NotNull(message = "Date applied is required")
    private LocalDate dateApplied;

    private String jobUrl;

    private String notes;

    public JobApplicationRequest() {
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
}