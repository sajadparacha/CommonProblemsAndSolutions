package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Solution;
import com.knowledge.sharing.repositories.SolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService{
    private SolutionRepository solutionRepository;

    public SolutionServiceImpl(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    @Override
    public void saveSolution(Solution solution) {
        solutionRepository.save(solution);
    }

    @Override
    public void updateSolution(Solution solution) {
        solutionRepository.save(solution);
    }

    @Override
    public void deleteSolution(long solutionId) {
        solutionRepository.deleteById(solutionId);
    }

    @Override
    public Solution findSolution(long solutionId) {
        return solutionRepository.findById(solutionId).get();
    }

    @Override
    public List<Solution> findAllSolutions() {
        return solutionRepository.findAll();
    }
}
