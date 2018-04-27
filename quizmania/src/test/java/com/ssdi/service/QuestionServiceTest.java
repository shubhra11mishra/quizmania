package com.ssdi.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssdi.dao.QuestionRepository;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class QuestionServiceTest {
/*
	@Injectable
	private QuestionRepository QuestionRepo;

	@Tested
	private QuestionService QuestionService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateQuestion() {
		Quiz q = new Quiz("Ancient History", 20, "history", "draft");

		Question question = new Question(new Integer(1), "What is the opposite of cold?", "hot", 10, q);

		new Expectations() {
			{
				QuestionRepo.save(question); // result.equals(q);
			}
		};
		QuestionService.createQuestion(question);
	}

	@Test
	public void testFindById() {
		Quiz q = new Quiz("Ancient History", 20, "history", "draft");
		Question question = new Question(new Integer(1), "What is the opposite of hot?", "cold", 10, q);
		Question question2 = new Question(new Integer(2), "What is the opposite of cold?", "hot", 10, q);

		new Expectations() {
			{
				QuestionRepo.save(question); // result.equals(q);
				QuestionRepo.save(question2); // result.equals(q);
				//QuestionRepo.findByQuizID(q.getQuizID());
			}
		};

		QuestionService.createQuestion(question);
		QuestionService.createQuestion(question2);
		List<Question> actual = QuestionService.findById(q);

	}
*/
}
