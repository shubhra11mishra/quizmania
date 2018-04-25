package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.ExamineeRepository;
import com.ssdi.model.Examinee;

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
