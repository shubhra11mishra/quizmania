package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.Admin;


public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	public void deleteByEmail(String email);
}
