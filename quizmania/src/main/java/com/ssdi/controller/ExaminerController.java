package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.Examiner;
import com.ssdi.service.ExaminerService;


@RestController
@RequestMapping("/quizmania/examiner")
public class ExaminerController {

	@Autowired
	ExaminerService examinerService;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examiner register(@RequestBody Examiner examiner) {
		return examinerService.createExaminer(examiner);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void delete(@RequestBody Examiner examiner) {
		examinerService.delete(examiner);
	}
	
}
