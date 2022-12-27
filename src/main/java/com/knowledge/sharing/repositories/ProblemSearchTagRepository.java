package com.knowledge.sharing.repositories;

import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.domain.ProblemSearchTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemSearchTagRepository extends JpaRepository<ProblemSearchTags,Long> {
}
