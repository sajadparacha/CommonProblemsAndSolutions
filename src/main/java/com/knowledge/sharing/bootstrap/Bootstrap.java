package com.knowledge.sharing.bootstrap;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.repositories.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    ApplicationRepository applicationRepository;

    public Bootstrap(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inserting Records in Database");
        Application application1= Application.builder().id(1l).applName("CSAS").applDescription("Cement Slurry Application").build();
        Application application2= Application.builder().id(2l).applName("BRAVO").applDescription("Drilling Best Practices").build();
        applicationRepository.save(application1);
        applicationRepository.save(application2);
        System.out.println("Inserting Records in Database");

    }
}
