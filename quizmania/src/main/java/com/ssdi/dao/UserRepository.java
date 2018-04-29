package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
	
	public User findByUserID(Integer id);
}
