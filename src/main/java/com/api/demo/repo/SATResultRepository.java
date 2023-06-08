package com.api.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.demo.entities.SATResult;

@Repository
public interface SATResultRepository extends JpaRepository<SATResult, Long> {
	SATResult findByName(String name);
}

