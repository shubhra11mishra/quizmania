package com.ssdi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dao.ExamineeRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.Examinee;
import com.ssdi.model.User;
import com.ssdi.service.ExamineeService;

@RestController
@RequestMapping("/quizmania/examinee")
public class ExamineeController {
	
	@Autowired
	ExamineeService examineeService;
	@Autowired
	ExamineeRepository examineeRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Examinee register(@RequestBody Examinee examinee) {
		return examineeService.createExaminee(examinee);
	}
	
	@Transactional
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET, value="/quizCategories")
    public List<String> getQuizCategories() {
        return examineeRepository.getQuizCategories("approved");
    }
	@RequestMapping(method=RequestMethod.POST, value="/{userId}/takequiz")
	public void takeQuiz(@RequestBody int quizId, @PathVariable int userId) {
		examineeService.takeQuiz(userId, quizId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void delete(@RequestBody Examinee examinee) {
		examineeService.deleteExaminee(examinee);
	}

}
