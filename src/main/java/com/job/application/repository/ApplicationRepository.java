package com.job.application.repository;

import com.job.application.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

   ApplicationEntity findByCandidateNameAndCompanyName(String candidateName, String companyName);

}
