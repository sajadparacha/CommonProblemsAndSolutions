package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.CommonProblem;

import java.util.List;
import java.util.Map;

public interface CommonProblemService {
    public CommonProblem saveCommonProblem(CommonProblem commonProblem,long applicationId);
    public CommonProblem updateCommonProblem(CommonProblem commonProblem);
    public CommonProblem patchCommonProblem(CommonProblem commonProblem);

    public void deleteCommonProblem(long commonProblemId);
    public CommonProblem findCommonProblem(long commonProblemId);
    public List<CommonProblem> findAllCommonProblems();
    //    public List<CommonProblem> findAllCommonProblemsForAnApplication(long applicationId);
    public List<Map<String,Object>> findAllCommonProblemsForAnApplication(long applicationId);


}
