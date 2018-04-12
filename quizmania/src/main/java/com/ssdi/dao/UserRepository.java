package com.ssdi.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
}
