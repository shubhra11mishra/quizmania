package com.ssdi.user.examinee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeService {
	@Autowired
	ExamineeRepository examineeService;
	
	public Examinee getExamineeByEmail(Examinee examinee) {
		return examineeService.findByEmail(examinee.getEmail());
	}

	public Examinee createExaminee(Examinee examinee) {
		return examineeService.save(examinee);
	}
}
