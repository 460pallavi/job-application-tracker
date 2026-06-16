package com.job.application.service;

import com.job.application.ApplicationStatus;
import com.job.application.dto.ApplicationRequestDto;
import com.job.application.dto.ApplicationResponseDto;
import com.job.application.entity.ApplicationEntity;
import com.job.application.exception.ApplicationAlreadyExistException;
import com.job.application.exception.ApplicationNotFoundException;
import com.job.application.exception.InvalidApplicationStatusException;
import com.job.application.exception.InvalidStatusTransitionsException;
import com.job.application.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;



//    GetMapping
    public List<ApplicationEntity> getAllApplication(){
        return applicationRepository.findAll();
    }

//    GetMapping by Id
    public ApplicationEntity getById(Long id){
//      if(applicationRepository.existsById(id)){
//        return applicationRepository.getById(id);

       Optional<ApplicationEntity> application =
                  applicationRepository.findById(id);

 if(application.isEmpty()){
      throw new ApplicationNotFoundException("");
   }
 return application.get();
 }

//postmapping
// public String addJobs(ApplicationEntity applicationEntity){
//
//        ApplicationEntity existing =
//                applicationRepository.findByCandidateNameAndCompanyName(
//                        applicationEntity.getCandidateName(),
//                        applicationEntity.getCompanyName()
//                );
//
//        if(existing != null) {
//            throw new ApplicationAlreadyExistException("");
//        }
//
//       if(applicationEntity.getStatus() != null){
//           throw new InvalidApplicationStatusException("");
//       }
//        applicationEntity.setStatus(ApplicationStatus.Applied);
//
//        applicationRepository.save(applicationEntity);
//
//        return "Applied!";
//
//    }

    public ApplicationResponseDto addJobs(ApplicationRequestDto requestDto){

        ApplicationEntity existing = applicationRepository.findByCandidateNameAndCompanyName(
                requestDto.getCandidateName(),
                requestDto.getCompanyName()
        );

        if(existing != null){
            throw new ApplicationAlreadyExistException("");
        }
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setCandidateName(requestDto.getCandidateName());
        applicationEntity.setCompanyName(requestDto.getCompanyName());
        applicationEntity.setExpectedSalary(requestDto.getExpectedSalary());

        applicationEntity.setStatus(ApplicationStatus.Applied);
        applicationRepository.save(applicationEntity);

        ApplicationResponseDto responseDto = new ApplicationResponseDto();
            responseDto.setId(applicationEntity.getId());
            responseDto.setCandidateName(applicationEntity.getCandidateName());
            responseDto.setCompanyName(applicationEntity.getCompanyName());
            responseDto.setExpectedSalary(applicationEntity.getExpectedSalary());
            responseDto.setStatus(applicationEntity.getStatus());

        return responseDto;
    }


// PutMapping

    public String updateApplication(ApplicationEntity applicationEntity, Long id){

        ApplicationEntity existingApplication = getById(id);

    ApplicationStatus currentStatus = existingApplication.getStatus();
    ApplicationStatus newStatus = applicationEntity.getStatus();

        System.out.println("Current Status = " + currentStatus);
        System.out.println("New Status = " + newStatus);

        if(currentStatus == ApplicationStatus.Applied
                && newStatus != ApplicationStatus.Screening){
            throw new InvalidStatusTransitionsException("Invalid status transition");
        }

        if(currentStatus == ApplicationStatus.Screening
                && newStatus != ApplicationStatus.Interview){
            throw new InvalidStatusTransitionsException("Invalid status transition");
        }

        if(currentStatus == ApplicationStatus.Interview
                && newStatus != ApplicationStatus.Offered){
            throw new InvalidStatusTransitionsException("Invalid status transition");
        }

        if(currentStatus == ApplicationStatus.Offered
                && newStatus != ApplicationStatus.Rejected){
            throw new InvalidStatusTransitionsException("Invalid status transition");
        }

        if(currentStatus == ApplicationStatus.Rejected
                && newStatus != ApplicationStatus.Hired){
            throw new InvalidStatusTransitionsException("Invalid status transition");
        }

        existingApplication.setStatus(newStatus);

        applicationRepository.save(existingApplication);

        return "Application update";
    }

}
