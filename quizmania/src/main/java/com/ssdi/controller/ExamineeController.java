package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.Examinee;
import com.ssdi.service.ExamineeService;

@RestController
@RequestMapping("/quizmania/examinee")
public class ExamineeController {
	
	@Autowired
	ExamineeService examineeService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Examinee login(@RequestBody Examinee examinee) {		
		return examineeService.getExamineeByEmail(examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examinee register(@RequestBody Examinee examinee) {
		return examineeService.createExaminee(examinee);
	}

}
