package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.ProblemSearchTags;
import com.knowledge.sharing.services.ProblemSearchTagsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problemSearchTagsController")
public class ProblemSearchTagsController {

    ProblemSearchTagsService  problemSearchTagsService;

    public ProblemSearchTagsController(ProblemSearchTagsService problemSearchTagsService) {
        this.problemSearchTagsService = problemSearchTagsService;
    }

    @GetMapping("/allProblemSearchTagss")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemSearchTags> getAllProblemSearchTags(){
        return problemSearchTagsService.findAllProblemSearchTags();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ProblemSearchTags findProblemSearchTags(@PathVariable long id){
        return problemSearchTagsService.findProblemSearchTags(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveProblemSearchTags(@RequestBody ProblemSearchTags problemSearchTags){
        problemSearchTagsService.saveProblemSearchTags(problemSearchTags);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteProblemSearchTags(@PathVariable long id){
        problemSearchTagsService.deleteProblemSearchTags(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateProblemSearchTags(@RequestBody ProblemSearchTags problemSearchTags){
        problemSearchTagsService.updateProblemSearchTags(problemSearchTags);
    }
}
