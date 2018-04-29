/**
 * 
 */
package com.ssdi.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.dao.ExaminerRepository;
import com.ssdi.dao.QuizRepository;
import com.ssdi.model.Quiz;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

/**
 * @author anuba
 *
 */

public class QuizServiceTest {

/*	@Injectable
	private QuizRepository quizRepo;

	@Tested
	private QuizService quizService;

	*//**
	 * @throws java.lang.Exception
	 *//*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@Before
	public void setUp() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@After
	public void tearDown() throws Exception {
	}

	*//**
	 * Test method for
	 * {@link com.ssdi.service.QuizService#createQuiz(com.ssdi.model.Quiz)}.
	 *//*
	@Test
	public void testCreateQuiz() {
		Quiz q = new Quiz("Ancient History", 20, "history", "draft");

		new Expectations() {
			{
				quizRepo.save(q); // result.equals(q);
			}
		};

		quizService.createQuiz(q);

	}

	*//**
	 * Test method for {@link com.ssdi.service.QuizService#viewQuiz()}.
	 *//*
	@Test
	public void testViewQuiz() {
		Quiz q = new Quiz("Ancient History", 20, "history", "draft");
		Quiz q2 = new Quiz("Modern Biology", 30, "biology", "draft");

		new Expectations() {
			{
				quizRepo.save(q); // result.equals(q);
				quizRepo.save(q2); // result.equals(q);
				quizRepo.findAll();
			}
		};

		quizService.createQuiz(q);
		quizService.createQuiz(q2);
		quizService.viewQuiz();
	}

	*//**
	 * Test method for
	 * {@link com.ssdi.service.QuizService#findById(java.lang.Integer)}.
	 *//*
	@Test
	public void testFindById() {
		Quiz q = new Quiz("Ancient History", 20, "history", "draft");

		new Expectations() {
			{
				quizRepo.save(q); // result.equals(q);
				quizRepo.findById(1);
			}
		};

		quizService.createQuiz(q);
		Quiz actual = quizService.findById(1);
	}
*/
}
