package com.ssdi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Quiz;


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
		Optional<Quiz> q = quizRepository.findById(quizID);
		if (q.get() != null) 
			return q.get();
		else 
			return null;
	}

	public List<Quiz> findAllApprovedQuizzes(){
		List<Quiz> allQuizzes =  quizRepository.findAll();
		List<Quiz> approvedQuizzes = new ArrayList<>();
		for(Quiz quiz : allQuizzes) {
			if(quiz.getStatus().equalsIgnoreCase("approved")) {
				approvedQuizzes.add(quiz);
			}
		}
		return approvedQuizzes;
	}
	
	public List<Quiz> findAllAttemptedQuizzes(int userID){
		return null;
	}

}
