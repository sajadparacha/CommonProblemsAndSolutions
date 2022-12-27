package com.knowledge.sharing.services;

import com.knowledge.sharing.domain.ProblemSearchTags;

import java.util.List;

public interface ProblemSearchTagsService {
    public void saveProblemSearchTags(ProblemSearchTags problemSearchTags);
    public void updateProblemSearchTags(ProblemSearchTags problemSearchTags);
    public void deleteProblemSearchTags(long problemSearchTagsId);
    public ProblemSearchTags findProblemSearchTags(long problemSearchTagsId);
    public List<ProblemSearchTags> findAllProblemSearchTags();

}
