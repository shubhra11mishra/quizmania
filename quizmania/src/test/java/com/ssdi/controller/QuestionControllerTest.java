package com.ssdi.controller;

import com.ssdi.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.singletonList;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.context.ContextLoaderTest;
import com.ssdi.controller.QuestionController;
import com.ssdi.controller.QuizController;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;
import com.ssdi.service.QuestionService;



public class QuestionControllerTest extends ContextLoaderTest{

/*	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	private QuestionController controller;
	
	@MockBean
	private QuizController controller1;
	
	@MockBean
	private QuestionService service;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testViewAllQuestion() throws Exception {
		Question question = new Question();
	    question.setPoints(3);

	       List<Question> allQuestions = singletonList(question);

	       //given(controller.getAllQuestion()).willReturn(allQuestions);
		
		this.mockMvc.perform(get("http://localhost:8080/quizmania/examiner/viewQuestion").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].points", is(question.getPoints())));
	}
	
	
	@Test
	public void testViewQuestionById() throws Exception {
		
		Quiz quiz=new Quiz();
		quiz.setQuizID(1);
		quiz.setTitle("Quant");
		quiz.setTimeLimit(30);
		quiz.setCategory("Maths");
		quiz.setStatus("pending");
	    
		Question question = new Question();
		
	    ArrayList<Question> questions = new ArrayList<Question>();
	    questions.add(question);

	       
	    //given(controller.getQuizQuestionsById(quiz.getQuizID())).willReturn(questions);
		
		this.mockMvc.perform(get("http://localhost:8080/quizmania/examiner/viewQuestion/"+quiz.getQuizID()).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk());
	}
	*/
}
