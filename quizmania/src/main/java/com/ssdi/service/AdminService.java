package com.ssdi.service;

import java.util.Optional;

// AdminService class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.AdminPasscodeRepository;
import com.ssdi.dao.AdminRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.AdminPasscode;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AdminPasscodeRepository adminPasscodeRepository;
	
	@Transactional
	public Admin createAdmin(Admin admin) {
		Optional<AdminPasscode> adminPasscode = adminPasscodeRepository.findById(admin.getPasscode());
		if(adminPasscode.isPresent()) {
			return adminRepository.save(admin);
		}else {
			return new Admin();
		}
		
	}


	@Transactional
	public void deleteAdmin(Admin admin) {
		adminRepository.deleteByEmail(admin.getEmail());
		
	}

}
