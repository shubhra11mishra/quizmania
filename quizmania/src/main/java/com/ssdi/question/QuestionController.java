package com.ssdi.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;


@RestController
@RequestMapping("/quizmania/examiner")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/quiz/createQuiz")
	public void createQuiz(@RequestBody Question question) {
		// TODO add questions one-by-one to quiz 
		 questionService.createQuestion(question);
	}
	
	
	
	
	
}

