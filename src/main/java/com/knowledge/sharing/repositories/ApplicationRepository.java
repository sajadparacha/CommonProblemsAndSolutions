package com.knowledge.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knowledge.sharing.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
