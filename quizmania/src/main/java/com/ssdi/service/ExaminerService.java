package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.ExaminerRepository;
import com.ssdi.model.Examiner;


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
