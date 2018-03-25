package com.ssdi.user.examiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/quizmania/examiner")
public class ExaminerController {

	@Autowired
	ExaminerService examinerService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Examiner login(@RequestBody Examiner examiner) {		
		return examinerService.getExaminerByEmail(examiner);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examiner register(@RequestBody Examiner examiner) {
		return examinerService.createExaminer(examiner);
	}
	
}
