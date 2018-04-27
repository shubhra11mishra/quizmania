package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;
import com.ssdi.model.Examinee;


public interface ExamineeRepository extends CrudRepository<Examinee, Integer>{
	public void deleteByEmail(String email);
}
