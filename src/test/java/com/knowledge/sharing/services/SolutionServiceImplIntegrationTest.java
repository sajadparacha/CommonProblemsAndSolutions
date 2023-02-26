package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Solution;
import com.knowledge.sharing.repositories.SolutionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SolutionServiceImplIntegrationTest {

//    @Test
//    void saveSolution() {
//    }
    @Autowired
    SolutionRepository solutionRepository;
    @Test
    void updateSolution() {
        Solution solution=solutionRepository.findById(1l).get();
        solution.setSolDescription("Test From integration test class");
        solutionRepository.save(solution);

        assertEquals("Test From integration test class",solutionRepository.findById(1l).get().getSolDescription());


    }

    @Test
    void deleteSolution() {
        solutionRepository.deleteById(1l);
        assertEquals(false,solutionRepository.findById(1l).isPresent());
    }

    @Test
    void findSolution() {
        assertEquals(true,solutionRepository.findById(1l).isPresent());
    }

    @Test
    void findAllSolutions() {
    }
}