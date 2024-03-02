package com.knowledge.sharing.controller;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.services.CommonProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commonProblemController")
public class CommonProblemController {

    CommonProblemService  commonProblemService;

    public CommonProblemController(CommonProblemService commonProblemService) {
        this.commonProblemService = commonProblemService;
    }

    @GetMapping("/application/{applicationId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Map<String,Object>> getAllCommonProblemsForAnApplication(@PathVariable("applicationId") String applicationId)
    //throws Exception
    {

        long applicationID=Long.parseLong(applicationId);
        //        ObjectMapper objectMapper= new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(commonProblems));

        return commonProblemService.findAllCommonProblemsForAnApplication(applicationID);

    }
    @GetMapping("/allCommonProblems")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CommonProblem> getAllCommonProblems(){
        return commonProblemService.findAllCommonProblems();
    }



//    @GetMapping("/{id}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public CommonProblem findCommonProblem(@PathVariable long id){
//        CommonProblem commonProblem= commonProblemService.findCommonProblem(id);
//
//
//        return commonProblem;
//    }
    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map<String,Object> findCommonProblem(@PathVariable long id){
        CommonProblem commonProblem= commonProblemService.findCommonProblem(id);
        Application application=commonProblem.getApplication();
        Map<String,Object> commponProblemMap= new HashMap<>();
        commponProblemMap.put("application",application);
        commponProblemMap.put("commonProblem",commonProblem);


        return commponProblemMap;
    }

    @PostMapping("/application/{applicationId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveCommonProblem(@RequestBody CommonProblem commonProblem,@PathVariable long applicationId){
        commonProblemService.saveCommonProblem(commonProblem,applicationId);
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
    @PatchMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void patchCommonProblem(@RequestBody CommonProblem commonProblem){
        commonProblemService.patchCommonProblem(commonProblem);
    }
}
