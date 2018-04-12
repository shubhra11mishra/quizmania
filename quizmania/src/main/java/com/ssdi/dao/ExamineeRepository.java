package com.ssdi.user.examinee;

import org.springframework.data.repository.CrudRepository;


public interface ExamineeRepository extends CrudRepository<Examinee, Integer>{
	public Examinee findByEmail(String email);
}
