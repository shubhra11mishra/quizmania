package com.ssdi.user.examiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExaminerService {
	
	@Autowired
	ExaminerRepository examinerRepository;

	@Transactional
	public Examiner createExaminer(Examiner examiner) {
		return examinerRepository.save(examiner);
	}

	@Transactional
	public void delete(Examiner examiner) {
		examinerRepository.deleteByEmail(examiner.getEmail());
	}

	

}
