package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.services.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicationController")
public class ApplicationController {

    ApplicationService  applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/allApplications")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Application> getAllApplications(){
        return applicationService.findAllApplications();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Application findApplication(@PathVariable long id){
        return applicationService.findApplication(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveApplication(@RequestBody Application application){
        applicationService.saveApplication(application);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteApplication(@PathVariable long id){
        applicationService.deleteApplication(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateApplication(@RequestBody Application application){
        applicationService.updateApplication(application);
    }
}
