package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.ExamineeRepository;
import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.Examinee;
import com.ssdi.model.Quiz;


@Service
public class ExamineeService {
	@Autowired
	ExamineeRepository examineeRepository;
	@Autowired
	QuizRepository quizRepository;


	public Examinee createExaminee(Examinee examinee) {
		return examineeRepository.save(examinee);
	}

	public void takeQuiz(int userId, int quizId) {
		/*Examinee examinee = examineeRepository.findById(userId).get();
		Quiz quiz = quizRepository.findById(quizId).get();
		examinee.getQuizList().add(quiz);
		quiz.getExamineeList().add(examinee);
		examineeRepository.save(examinee);
		quizRepository.save(quiz);*/
	}
	
	@Transactional
	public void deleteExaminee(Examinee examinee) {
		examineeRepository.deleteByEmail(examinee.getEmail());
		
	}
}
