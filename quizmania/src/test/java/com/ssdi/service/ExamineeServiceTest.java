package com.ssdi.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ssdi.dao.AdminPasscodeRepository;
import com.ssdi.dao.AdminRepository;
import com.ssdi.dao.ExamineeRepository;
import com.ssdi.dao.ExaminerRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.AdminPasscode;
import com.ssdi.model.Examinee;
import com.ssdi.model.Examiner;

import mockit.*;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class ExamineeServiceTest {


	@Injectable
	private ExamineeRepository examineeRepository;

	@Tested
	private ExamineeService examineeService;
	
	@Test
	public void createExaminerServiceTest() {
		Examinee examinee = new Examinee("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword");

		new Expectations() {
			{
				examineeRepository.save(examinee);
				examineeRepository.deleteByEmail(examinee.getEmail());
			}
		};

		examineeService.createExaminee(examinee);
		examineeService.deleteExaminee(examinee);
	}


}
