package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;

import java.util.List;

public interface ApplicationService {
    public void saveApplication(Application application);
    public void updateApplication(Application application);
    public void deleteApplication(long applicationId);
    public Application findApplication(long applicationId);
    public List<Application> findAllApplications();

}
