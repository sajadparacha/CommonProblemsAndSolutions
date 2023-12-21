package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.repositories.ApplicationRepository;
import com.knowledge.sharing.repositories.CommonProblemRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommonProblemServiceImpl implements CommonProblemService{
    private CommonProblemRepository commonProblemRepository;
    private ApplicationRepository applicationRepository;

    public CommonProblemServiceImpl(CommonProblemRepository commonProblemRepository,ApplicationRepository applicationRepository) {
        this.commonProblemRepository = commonProblemRepository;
        this.applicationRepository=applicationRepository;
    }

    @Override
    public CommonProblem saveCommonProblem(CommonProblem commonProblem,long applicationId) {
        //**This common problme belongs to an applicaiton so application should be set here
        Application application=applicationRepository.findById(applicationId).get();
        commonProblem.setApplication(application);
        return commonProblemRepository.save(commonProblem);
    }

    @Override
    public CommonProblem updateCommonProblem(CommonProblem commonProblem) {
        return commonProblemRepository.save(commonProblem);
    }

    @Override
    public CommonProblem patchCommonProblem(CommonProblem commonProblem) {
        CommonProblem commonProblemExisting=commonProblemRepository.findById(commonProblem.getCommonProblemId()).get();
        commonProblemExisting.setProblemDesc(commonProblem.getProblemDesc());

        return commonProblemRepository.save(commonProblemExisting);
    }

    @Override
    public void deleteCommonProblem(long commonProblemId) {
        commonProblemRepository.deleteById(commonProblemId);
    }

    @Override
    public CommonProblem findCommonProblem(long commonProblemId) {
        return commonProblemRepository.findById(commonProblemId).get();
    }

    @Override
    public List<CommonProblem> findAllCommonProblems() {
        return commonProblemRepository.findAll();
    }
    @Override
//    public List<CommonProblem> findAllCommonProblemsForAnApplication(long applicationId) {
//
//        List<CommonProblem> commonProblems= new ArrayList<>();
//         applicationRepository.
//                findById(applicationId).
//                get()
//                .getCommonProblems()
//                .stream()
//                .forEach(  commonProblem ->
//                {
//                    commonProblem.setApplication(commonProblem.getApplication());
//                    commonProblems.add(commonProblem);
//                } );
//         return commonProblems;
//    }

    public List<Map<String,Object>> findAllCommonProblemsForAnApplication(long applicationId) {

        List<Map<String,Object>> commonProblems= new ArrayList<Map<String,Object>>();
        applicationRepository.
                findById(applicationId).
                get()
                .getCommonProblems()
                .stream()
                .forEach(  commonProblem ->
                {
                    Application application=commonProblem.getApplication();

                    commonProblem.setApplication(commonProblem.getApplication());
                    Map<String,Object> commonProblemMap= new HashMap<>();
                    commonProblemMap.put("application",application);
                    commonProblemMap.put("commonProblem",commonProblem);
                    commonProblems.add(commonProblemMap);
                } );
        return commonProblems;
    }
}
