package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.Application;
import com.knowledge.sharing.domain.CommonProblem;

import java.util.List;

public interface CommonProblemService {
    public void saveCommonProblem(CommonProblem commonProblem);
    public void updateCommonProblem(CommonProblem commonProblem);
    public void deleteCommonProblem(long commonProblemId);
    public CommonProblem findCommonProblem(long commonProblemId);
    public List<CommonProblem> findAllCommonProblems();

}
