package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.repositories.CommonProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonProblemServiceImpl implements CommonProblemService{
    private CommonProblemRepository commonProblemRepository;

    public CommonProblemServiceImpl(CommonProblemRepository commonProblemRepository) {
        this.commonProblemRepository = commonProblemRepository;
    }

    @Override
    public CommonProblem saveCommonProblem(CommonProblem commonProblem) {
        return commonProblemRepository.save(commonProblem);
    }

    @Override
    public CommonProblem updateCommonProblem(CommonProblem commonProblem) {
        return commonProblemRepository.save(commonProblem);
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
}
