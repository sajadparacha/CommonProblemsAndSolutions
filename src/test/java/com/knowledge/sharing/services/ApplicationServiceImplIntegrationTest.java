package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.repositories.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest

class ApplicationServiceImplIntegrationTest {
    @Autowired
    ApplicationRepository applicationRepository;
    @Test
    void getAllApplications() {
        List<Application> applications=applicationRepository.findAll();
        //assertEquals("CSAS",applications.stream().filter());
        assertEquals(5,applications.size());
    }

    @Test
    void findApplication() {
        Optional<Application> applicationOptional=applicationRepository.findById(1L);
        assertEquals("DIOR",applicationOptional.get().getApplDescription());
    }

//    @Test
//    void saveApplication() {
//        Application application=Application.builder().applicationId(7l).applDescription("Test Application").applName("testApp").build();
//        applicationRepository.save(application);
//        assertEquals(7,application.getApplicationId());
//    }

    @Test
    void deleteApplication() {
        applicationRepository.deleteById(1L);
        assertFalse(applicationRepository.findById(1L).isPresent());
    }

    @Test
    void updateApplication() {
        Application application=applicationRepository.findById(2L).get();
        application.setApplName("test");

        applicationRepository.save(application);

        assertEquals("test",applicationRepository.findById(2L).get().getApplName());
    }
}