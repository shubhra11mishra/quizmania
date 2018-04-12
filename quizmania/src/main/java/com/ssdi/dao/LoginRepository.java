package com.ssdi.login;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.user.User;

public interface LoginRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
}
