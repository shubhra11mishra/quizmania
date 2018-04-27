package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.ExamineeRepository;
import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Examinee;
import com.ssdi.model.Quiz;


@Service
public class ExamineeService {
	@Autowired
	ExamineeRepository examineeRepository;
	@Autowired
	QuizRepository quizRepository;
	
	public Examinee getExamineeByEmail(Examinee examinee) {
		return examineeRepository.findByEmail(examinee.getEmail());
	}

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
}
