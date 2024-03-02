package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.Solution;
import com.knowledge.sharing.repositories.SolutionRepository;
import com.knowledge.sharing.services.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solutionController")
public class SolutionController {

    SolutionService  solutionService;
    private final SolutionRepository solutionRepository;

    public SolutionController(SolutionService solutionService,
                              SolutionRepository solutionRepository) {
        this.solutionService = solutionService;
        this.solutionRepository = solutionRepository;
    }

    @GetMapping("/allSolutions")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Solution> getAllSolutions(){
        return solutionService.findAllSolutions();
    }

    @GetMapping("/problem/{problemId}/allSolutions")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Map<String,Object>> getAllSolutionsForGivenProblem(@PathVariable long problemId){
        return solutionService.findAllSolutionsForGivenProblem(problemId);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Solution findSolution(@PathVariable long id){
        return solutionService.findSolution(id);
    }

    //@PostMapping
    @PostMapping("/problem/{problemId}")

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveSolution(@RequestBody Solution solution,@PathVariable long problemId){
        solutionService.saveSolution(solution,problemId);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteSolution(@PathVariable long id){
        solutionService.deleteSolution(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateSolution(@RequestBody Solution solution){
        solutionService.updateSolution(solution);
    }

    @PatchMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void patchSolution(@RequestBody Solution solution){

        Solution solution1Existing = solutionRepository.findById(solution.getSolutionId()).get();
        solution1Existing.setSolDescription(solution.getSolDescription());

        solutionService.saveSolution(solution1Existing);



    }

}
