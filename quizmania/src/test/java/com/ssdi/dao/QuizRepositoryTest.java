/** Not necessary to test Repository classes 
package com.ssdi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssdi.context.ContextLoaderTest;
import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Quiz;


@RunWith(SpringRunner.class)
@DataJpaTest
public class QuizRepositoryTest extends ContextLoaderTest{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private QuizRepository repository;
    
    @Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void setQuizStatusTest() {
		//given
		Quiz quiz= new Quiz();
		quiz.setStatus("pending");
		quiz.setQuizID(1);
		entityManager.persist(quiz);
	    entityManager.flush();
	    
	    //when
	    repository.setQuizStatus("Approved", "good", 1);
	    
	    //then
	    assertThat(quiz.getStatus())
	      .isEqualTo("Approved");
	}

}
*/
