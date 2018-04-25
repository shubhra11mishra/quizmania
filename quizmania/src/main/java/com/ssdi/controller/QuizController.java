package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Quiz;
import com.ssdi.service.QuizService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/quizmania/examiner")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired ObjectMapper objectMapper;
	
	@RequestMapping(method=RequestMethod.POST, value="/quiz")
	public void createQuiz(@RequestBody Quiz quiz) {		
		 quizService.createQuiz(quiz);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewQuiz")
    public Collection<Quiz> getAllQuiz() {
        return quizRepository.findAll().stream().collect(Collectors.toList());
    }
	
	@Transactional
	@RequestMapping(method=RequestMethod.GET, value="/updateStatusYes/{id}")
	public void updateQuiz(@PathVariable(value = "id") Integer quizID) {

	    quizRepository.setQuizStatus("Approved",quizID);
	    
	    
	    
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.GET, value="/updateStatusNo/{id}")
	public void updateQuiz1(@PathVariable(value = "id") Integer quizID) {

	    quizRepository.setQuizStatus("Rejected",quizID);
	    
	    
	    
	}
	
	
//	@RequestMapping(value = "/updateStatusYes/{id}", method = RequestMethod.POST )
//	public @ResponseBody ResponseEntity<Quiz> update(@PathVariable int id, HttpServletRequest request) throws IOException
//	{
//	    Quiz quiz = quizService.findById(id);
//	    Quiz updatedQuiz = objectMapper.readerForUpdating(quiz).readValue(request.getReader());
//	    quizRepository.saveAndFlush(updatedQuiz);
//	    return new ResponseEntity<>(updatedQuiz, HttpStatus.ACCEPTED);
//	}
	
	
	
}

