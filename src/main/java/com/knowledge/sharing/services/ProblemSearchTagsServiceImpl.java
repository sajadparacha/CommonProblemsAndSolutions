package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.ProblemSearchTags;
import com.knowledge.sharing.repositories.ProblemSearchTagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemSearchTagsServiceImpl implements ProblemSearchTagsService{
    private ProblemSearchTagsRepository problemSearchTagsRepository;

    public ProblemSearchTagsServiceImpl(ProblemSearchTagsRepository problemSearchTagsRepository) {
        this.problemSearchTagsRepository = problemSearchTagsRepository;
    }

    @Override
    public void saveProblemSearchTags(ProblemSearchTags problemSearchTags) {
        problemSearchTagsRepository.save(problemSearchTags);
    }

    @Override
    public void updateProblemSearchTags(ProblemSearchTags problemSearchTags) {
        problemSearchTagsRepository.save(problemSearchTags);
    }

    @Override
    public void deleteProblemSearchTags(long problemSearchTagsId) {
        problemSearchTagsRepository.deleteById(problemSearchTagsId);
    }

    @Override
    public ProblemSearchTags findProblemSearchTags(long problemSearchTagsId) {
        return problemSearchTagsRepository.findById(problemSearchTagsId).get();
    }

    @Override
    public List<ProblemSearchTags> findAllProblemSearchTags() {
        return problemSearchTagsRepository.findAll();
    }
}
