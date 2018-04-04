package com.ssdi.question;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
	}

	

}
