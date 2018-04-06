package com.ssdi.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/quizmania/examiner")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizRepository quizRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/quiz")
	public void createQuiz(@RequestBody Quiz quiz) {		
		 quizService.createQuiz(quiz);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewQuiz")
    public Collection<Quiz> getAllQuiz() {
        return quizRepository.findAll().stream().collect(Collectors.toList());
    }
	
	
	
	
	
}

