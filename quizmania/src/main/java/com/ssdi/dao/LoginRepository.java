package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.User;


public interface LoginRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
}
