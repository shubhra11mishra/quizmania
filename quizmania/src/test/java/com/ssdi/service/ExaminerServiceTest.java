package com.ssdi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.dao.ExaminerRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.Examiner;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SpringBootTest
public class ExaminerServiceTest {

	@Injectable
	private ExaminerRepository examinerRepository;

	@Tested
	private ExaminerService examinerService;

	@Test
	public void createExaminerServiceTest() {
		Examiner examiner = new Examiner("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword");

		new Expectations() {
			{
				examinerRepository.save(examiner);
				examinerRepository.deleteByEmail(examiner.getEmail());
			}
		};

		examinerService.createExaminer(examiner);
		examinerService.delete(examiner);
	}

}
