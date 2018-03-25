package com.ssdi.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;

	public Admin getAdminByEmail(Admin admin) {
		return adminRepository.findByEmail(admin.getEmail());
	}
	
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
