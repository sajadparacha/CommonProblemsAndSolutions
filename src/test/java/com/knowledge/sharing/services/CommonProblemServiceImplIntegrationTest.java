package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.repositories.ApplicationRepository;
import com.knowledge.sharing.repositories.CommonProblemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommonProblemServiceImplIntegrationTest {
    @Autowired
    CommonProblemRepository commonProblemRepository;
    @Autowired
    ApplicationRepository applicationRepository;
//    @Test
//    void saveCommonProblem() {
//        CommonProblem commonProblem=CommonProblem.builder().commonProblemId(9l).problemDesc("Test Problem").build();
//        commonProblem.setApplication(applicationRepository.findById(1l).get());
//        commonProblemRepository.save(commonProblem);
//    }

    @Test
    void updateCommonProblem() {
        CommonProblem commonProblem= commonProblemRepository.findById(1l).get();
        commonProblem.setProblemDesc("Changing from test class");
        commonProblemRepository.save(commonProblem);

        CommonProblem commonProblem1=commonProblemRepository.findById(1l).get();
        assertEquals("Changing from test class",commonProblem1.getProblemDesc());
    }

    @Test
    void deleteCommonProblem() {
        commonProblemRepository.deleteById(1l);
//        CommonProblem commonProblem=commonProblemRepository.findById(1l);
        assertEquals(false,commonProblemRepository.findById(1l).isPresent());
    }

    @Test
    void findCommonProblem() {
        assertEquals(true,commonProblemRepository.findById(1l).isPresent());
    }

    @Test
    void findAllCommonProblems() {
        assertEquals(5,commonProblemRepository.findAll().size());
    }
}