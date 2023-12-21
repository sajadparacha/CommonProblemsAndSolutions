package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService{
    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public void updateApplication(Application application) {
        applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(long applicationId) {
        applicationRepository.deleteById(applicationId);
    }

    @Override
    public Application findApplication(long applicationId) {
        return applicationRepository.findById(applicationId).get();
    }

    @Override
    public List<Application> findAllApplications() {

        return applicationRepository.findAll();
    }
}
