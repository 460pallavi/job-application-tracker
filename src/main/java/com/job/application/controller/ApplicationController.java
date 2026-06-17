package com.job.application.controller;

import com.job.application.dto.ApplicationRequestDto;
import com.job.application.dto.ApplicationResponseDto;
import com.job.application.entity.ApplicationEntity;
import com.job.application.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public List<ApplicationEntity> getAllApplication(){
        return applicationService.getAllApplication();
    }

    @GetMapping("/{id}")
    public ApplicationResponseDto getByIs(@PathVariable Long id){
        return applicationService.getById(id);
    }



//    @PostMapping
//    public String addJob(@Valid @RequestBody ApplicationEntity applicationEntity){
//        return applicationService.addJobs(applicationEntity);
//    }
    @PostMapping
    public ApplicationResponseDto addJob(@RequestBody ApplicationRequestDto requestDto){
        return  applicationService.addJobs(requestDto);
    }

    @PutMapping("/{id}")

    public String updateJob(@PathVariable Long id, @RequestBody ApplicationEntity applicationEntity){

        return applicationService.updateApplication(applicationEntity, id);
    }
}
