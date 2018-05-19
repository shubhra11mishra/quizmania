package com.ssdi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.dao.QuestionRepository;
import com.ssdi.dao.QuizRepository;
import com.ssdi.dao.ResponseRepository;
import com.ssdi.dao.UserRepository;
import com.ssdi.model.Attempt;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;
import com.ssdi.model.Response;
import com.ssdi.model.User;
import com.ssdi.service.AttemptService;
import com.ssdi.service.QuestionService;
import com.ssdi.service.QuizService;

@RestController
@RequestMapping("/quizmania")
public class AttemptController {

	@Autowired
	AttemptService attemptService;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	QuestionService questionService;
	@Autowired
	ResponseRepository responseRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/examinee/{userid}/takequiz/{quizid}")
	public Attempt markAttempt(@RequestBody ArrayList<String> responses, @PathVariable(value = "userid") int userID,
			@PathVariable(value = "quizid") int quizID) throws Exception {
		System.out.println("In attempt controller, grading quiz attempt... ");
		for (int i = 0; i < responses.size(); i++) {
			//System.out.println("----" + responses.get(i).toString() + "----");
		}
		System.out.println("fianlly now: " + responses.toString());
		Optional<User> user = userRepository.findById(userID);
		Optional<Quiz> quiz = quizRepository.findById(quizID);
		if (user == null || quiz == null) {
			throw new Exception("Unknown user and/or quiz.");
		}
		//int count = attemptService.countByQuizIDAndUserID(quizID, userID);
		int count = 1;
		Attempt newAttempt = new Attempt(quiz.get(), user.get(), ++count);
		newAttempt = attemptService.save(newAttempt);
		ArrayList<Question> questions = (ArrayList<Question>) questionService.findById(quiz.get());
		for (int i = 0; i < questions.size(); i++) {
			newAttempt.setMaxScore(newAttempt.getMaxScore() + questions.get(i).getPoints());
			if (responses.get(i).equalsIgnoreCase(questions.get(i).getCorrect_answer())) {
				// correct answer!
				Response r = new Response(questions.get(i), newAttempt, responses.get(i), "correct");
				responseRepository.save(r);
				newAttempt.setUserScore(newAttempt.getUserScore() + questions.get(i).getPoints());
			} else {
				Response r = new Response(questions.get(i), newAttempt, responses.get(i), "wrong");
				responseRepository.save(r);
				// don't update user score because response is wrong 
			}
		}
		// calculate percentage
		newAttempt.setPercent((double) newAttempt.getUserScore()*100 / newAttempt.getMaxScore());
		// save the latest attempt with score
		return attemptService.save(newAttempt);
	}

}
