package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.Solution;
import com.knowledge.sharing.services.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solutionController")
public class SolutionController {

    SolutionService  solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/allSolutions")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Solution> getAllSolutions(){
        return solutionService.findAllSolutions();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Solution findSolution(@PathVariable long id){
        return solutionService.findSolution(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveSolution(@RequestBody Solution solution){
        solutionService.saveSolution(solution);
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
}
