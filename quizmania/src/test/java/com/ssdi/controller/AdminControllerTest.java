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
import com.ssdi.model.Admin;

public class AdminControllerTest extends ContextLoaderTest{

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	ObjectMapper objectMapper;

	private MockMvc mockMvc;


	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testAdminCreation() throws Exception {
		Admin admin = new Admin("TestUserAdminFirstName", "TestUserLastName", "TestUserAdminEmail", "TestUserPassword",
				"123456");
		
		this.mockMvc.perform(delete("/quizmania/admin/delete").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(admin))).andExpect(status().isOk());

		this.mockMvc.perform(post("/quizmania/admin/register").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(admin))).andExpect(status().isOk())
				 .andExpect(jsonPath("$.email").value("TestUserAdminEmail"))
				 .andExpect(jsonPath("$.userFirstName").value("TestUserAdminFirstName"));
		
		this.mockMvc.perform(delete("/quizmania/admin/delete").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(admin))).andExpect(status().isOk());
	
	}
}
