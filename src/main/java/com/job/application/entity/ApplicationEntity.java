package com.job.application.entity;

import com.job.application.ApplicationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String candidateName;
    private String companyName;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
//private String status;
    private String expectedSalary;


    public ApplicationEntity() {
    }

    public ApplicationEntity(Long id, String candidateName, String companyName, ApplicationStatus status, String expectedSalary) {
        this.id = id;
        this.candidateName = candidateName;
        this.companyName = companyName;
        this.status = status;
        this.expectedSalary = expectedSalary;
    }

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

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    //    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
}

