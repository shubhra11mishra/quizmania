package com.ssdi.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
