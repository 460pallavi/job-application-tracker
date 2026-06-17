package com.job.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ApplicationRequestDto {

    @NotBlank
    private String candidateName;
    @NotBlank
    private String companyName;
    @Positive
    private Long expectedSalary;

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
}
