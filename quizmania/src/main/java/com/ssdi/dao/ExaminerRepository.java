package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.Examiner;


public interface ExaminerRepository extends CrudRepository<Examiner, Integer>{
	public void deleteByEmail(String email);
}
