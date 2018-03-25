package com.ssdi.user.examiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminerService {
	
	@Autowired
	ExaminerRepository examinerService;
	
	public Examiner getExaminerByEmail(Examiner examiner) {
		return examinerService.findByEmail(examiner.getEmail());
	}

	public Examiner createExaminer(Examiner examiner) {
		return examinerService.save(examiner);
	}

}
