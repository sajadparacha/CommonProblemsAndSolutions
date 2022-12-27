package com.knowledge.sharing.repositories;

import com.knowledge.sharing.domain.CommonProblem;
import com.knowledge.sharing.domain.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution,Long> {
}
