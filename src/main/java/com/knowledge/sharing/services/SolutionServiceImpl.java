package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Solution;
import com.knowledge.sharing.repositories.CommonProblemRepository;
import com.knowledge.sharing.repositories.SolutionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SolutionServiceImpl implements SolutionService{
    private SolutionRepository solutionRepository;
    private CommonProblemRepository commonProblemRepository;

    public SolutionServiceImpl(SolutionRepository solutionRepository,CommonProblemRepository commonProblemRepository)
    {
        this.solutionRepository = solutionRepository;
        this.commonProblemRepository=commonProblemRepository;
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

//    @Override
//    public List<Solution> findAllSolutionsForGivenProblem(long problemId) {
//        List<Solution>  solutionList=new ArrayList<Solution>();
//        commonProblemRepository.findById(problemId).get().
//                getSolutions().stream().forEach(solution -> solutionList.add(solution));
//        return solutionList;
//    }

    @Override
    public List<Map<String,Object>> findAllSolutionsForGivenProblem(long problemId) {
        List<Map<String,Object>>  solutionList=new ArrayList<Map<String,Object>>();
        commonProblemRepository.findById(problemId).get().
                getSolutions().stream().forEach(

                        solution -> {
                            Map<String,Object> solutionMap= new HashMap<String,Object>();
                            solutionMap.put("solution",solution);
                            solutionMap.put("application",solution.getCommonProblem().getApplication());
                            solutionMap.put("commonProblem",solution.getCommonProblem());
                            solutionList.add(solutionMap);

                        }


                );
        return solutionList;
    }



    @Override
    public List<Solution> findAllSolutions() {
        return solutionRepository.findAll();
    }
}
