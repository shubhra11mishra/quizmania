package com.ssdi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.dao.QuestionRepository;
import com.ssdi.dao.QuizRepository;
import com.ssdi.dao.UserRepository;
import com.ssdi.model.Quiz;
import com.ssdi.model.Response;
import com.ssdi.model.User;
import com.ssdi.service.AttemptService;
import com.ssdi.service.QuizService;

@RestController
@RequestMapping("/quizmania")
public class AttemptController {
	
		@Autowired
		QuizService quizService;
		
		@Autowired
		AttemptService attemptService;

		@Autowired
		QuizRepository quizRepository;
		@Autowired
		UserRepository userRepository;
		@Autowired
		ObjectMapper objectMapper;
		@Autowired
		QuestionRepository questionRepository;

		@RequestMapping(method = RequestMethod.POST, value = "/examinee/{userid}/takequiz/{quizid}")
		public void createQuiz(@RequestBody ArrayList<Response> responses, @PathVariable(value = "userid") int userID, @PathVariable(value = "quizid") int quizID) throws Exception {
			System.out.println("In attempt controller!! grading user attempt... ");
			Optional<User> user = userRepository.findById(userID);
			/**
			if (user != null)
				quiz.setAuthor(user.get());
			else
				throw new Exception("User is unauthorized to create quiz.");
			quizService.createQuiz(quiz);
			*/
		}


}
