package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dao.QuestionRepository;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;
import com.ssdi.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/quizmania/examiner")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/quiz/createQuiz")
	public void createQuiz(@RequestBody Question question) {
		// TODO add questions one-by-one to quiz 
		 questionService.createQuestion(question);
	}
	
	/**
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewQuestion")
    public Collection<Question> getAllQuestion() {
        return questionRepository.findAll().stream().collect(Collectors.toList());
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewQuestion/{id}")
	@EntityGraph(value = "Question.quizID", type = EntityGraphType.FETCH)
	public Optional<Question> getQuestionById(@PathVariable(value = "id") int s) {
	    return questionRepository.findById(s);
	            }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewQuestion/{id}")
	public List<Question> getQuizQuestionsById(@PathVariable(value = "id") Quiz id) {
	    return questionService.findById(id);
	            
	}
	*/
}

