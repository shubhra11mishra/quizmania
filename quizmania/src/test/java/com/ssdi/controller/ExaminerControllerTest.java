package com.ssdi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.context.ContextLoaderTest;

import com.ssdi.model.Examiner;


public class ExaminerControllerTest extends ContextLoaderTest{

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testExaminerCreation() throws Exception {
		Examiner examiner = new Examiner("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword");
		
		this.mockMvc.perform(delete("/quizmania/examiner/delete").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(examiner))).andExpect(status().isOk());

		this.mockMvc.perform(post("/quizmania/examiner/register").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(examiner))).andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("TestUserEmail"))
				.andExpect(jsonPath("$.userFirstName").value("TestUserFirstName"));
		
		this.mockMvc.perform(delete("/quizmania/examiner/delete").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(examiner))).andExpect(status().isOk());
	}
}
