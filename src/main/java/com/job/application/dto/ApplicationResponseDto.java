package com.job.application.dto;

import com.job.application.ApplicationStatus;

public class ApplicationResponseDto {

    private Long id;
    private String candidateName;
    private String companyName;
    private Long expectedSalary;
    private ApplicationStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Long expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
