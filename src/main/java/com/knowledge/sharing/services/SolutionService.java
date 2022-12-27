package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.Solution;

import java.util.List;

public interface SolutionService {
    public void saveSolution(Solution solution);
    public void updateSolution(Solution solution);
    public void deleteSolution(long solutionId);
    public Solution findSolution(long solutionId);
    public List<Solution> findAllSolutions();

}
