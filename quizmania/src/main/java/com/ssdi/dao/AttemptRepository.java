package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.Attempt;

public interface AttemptRepository extends CrudRepository<Attempt, Integer>{
	
	public Attempt findByAttemptID(Integer id);
}
