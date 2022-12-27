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
    public List<Application> getAllSaleInformation(){
        return applicationService.findAllApplications();
    }
}
