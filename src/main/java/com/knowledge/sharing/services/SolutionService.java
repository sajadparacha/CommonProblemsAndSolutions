package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Solution;

import java.util.List;
import java.util.Map;

public interface SolutionService {
    void saveSolution(Solution solution);
    void saveSolution(Solution solution, long problemId);
    void updateSolution(Solution solution);
    void deleteSolution(long solutionId);
    Solution findSolution(long solutionId);
    List<Solution> findAllSolutions();

    List<Map<String,Object>> findAllSolutionsForGivenProblem(long problemId);
}
