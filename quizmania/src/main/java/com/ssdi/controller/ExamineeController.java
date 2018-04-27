package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.Examinee;
import com.ssdi.model.User;
import com.ssdi.service.ExamineeService;

@RestController
@RequestMapping("/quizmania/examinee")
public class ExamineeController {
	
	@Autowired
	ExamineeService examineeService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Examinee login(@RequestBody User user) {	
		System.out.println("Inside server Login");
		return null;
		//return examineeService.getExamineeByEmail(examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examinee register(@RequestBody Examinee examinee) {
		return examineeService.createExaminee(examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{userId}/takequiz")
	public void takeQuiz(@RequestBody int quizId, @PathVariable int userId) {
		examineeService.takeQuiz(userId, quizId);
	}

}
