package com.knowledge.sharing.repositories;

import com.knowledge.sharing.domain.CommonProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonProblemRepository extends JpaRepository<CommonProblem,Long> {
}
