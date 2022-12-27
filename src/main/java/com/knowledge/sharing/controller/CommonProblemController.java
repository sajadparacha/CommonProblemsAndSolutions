package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.services.CommonProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commonProblemController")
public class CommonProblemController {

    CommonProblemService  commonProblemService;

    public CommonProblemController(CommonProblemService commonProblemService) {
        this.commonProblemService = commonProblemService;
    }

    @GetMapping("/allCommonProblems")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CommonProblem> getAllCommonProblems(){
        return commonProblemService.findAllCommonProblems();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonProblem findCommonProblem(@PathVariable long id){
        return commonProblemService.findCommonProblem(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveCommonProblem(@RequestBody CommonProblem commonProblem){
        commonProblemService.saveCommonProblem(commonProblem);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteCommonProblem(@PathVariable long id){
        commonProblemService.deleteCommonProblem(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateCommonProblem(@RequestBody CommonProblem commonProblem){
        commonProblemService.updateCommonProblem(commonProblem);
    }
}
