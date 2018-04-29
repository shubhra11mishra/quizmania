package com.ssdi.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import java.util.List;

import static java.util.Collections.singletonList;
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
import com.ssdi.controller.QuizController;
import com.ssdi.model.Quiz;

public class QuizControllerTest extends ContextLoaderTest{

/*	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	private QuizController controller;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testViewQuiz() throws Exception {
		Quiz quiz = new Quiz();
	    quiz.setTitle("Quant");

	       List<Quiz> allQuizzes = singletonList(quiz);

	       given(controller.getAllQuizzes(0)).willReturn(allQuizzes);
		
		this.mockMvc.perform(get("http://localhost:8080/quizmania/examiner/viewQuiz").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].title", is(quiz.getTitle())));
	}
	*/
}
