package com.ssdi.service;

// AdminService class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.AdminRepository;
import com.ssdi.model.Admin;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	@Transactional
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Transactional
	public void deleteAdmin(Admin admin) {
		adminRepository.deleteByEmail(admin.getEmail());
	}

}
