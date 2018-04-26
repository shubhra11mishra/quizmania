package com.ssdi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.QuestionRepository;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;

import antlr.collections.List;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
	}

	public java.util.List<Question> findById(Quiz id) {
		return questionRepository.findByQuizIDOrderByNumberAsc(id);
	}

}
