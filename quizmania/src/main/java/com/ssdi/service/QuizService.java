package com.ssdi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Quiz;

import antlr.collections.List;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	public void createQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		quizRepository.save(quiz);
	}
	
	public void viewQuiz() {
		// TODO Auto-generated method stub
		quizRepository.findAll();
	}

	public Quiz findById(Integer quizID) {
		// TODO Auto-generated method stub
		quizRepository.findById(quizID);
		return null;
	}

	

}
