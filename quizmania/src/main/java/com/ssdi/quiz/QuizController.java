package com.ssdi.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;


@RestController
@RequestMapping("/quizmania/examiner")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@RequestMapping(method=RequestMethod.POST, value="/quiz")
	public void createQuiz(@RequestBody Quiz quiz) {		
		 quizService.createQuiz(quiz);
	}
	
	
	
	
	
}

