package com.ssdi.user.admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	public void deleteByEmail(String email);
}
