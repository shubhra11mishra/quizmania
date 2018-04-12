package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.Examinee;


public interface ExamineeRepository extends CrudRepository<Examinee, Integer>{
	public Examinee findByEmail(String email);
}
