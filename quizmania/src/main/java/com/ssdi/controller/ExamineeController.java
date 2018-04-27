package com.ssdi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dao.ExamineeRepository;
import com.ssdi.model.Examinee;
import com.ssdi.service.ExamineeService;

@RestController
@RequestMapping("/quizmania/examinee")
public class ExamineeController {
	
	@Autowired
	ExamineeService examineeService;
	@Autowired
	ExamineeRepository examineeRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Examinee login(@RequestBody Examinee examinee) {		
		return examineeService.getExamineeByEmail(examinee);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examinee register(@RequestBody Examinee examinee) {
		return examineeService.createExaminee(examinee);
	}
	
	@Transactional
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET, value="/quizCategories")
    public List<String> getQuizCategories() {
        return examineeRepository.getQuizCategories();
    }

}
