package com.ssdi.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.dao.ExaminerRepository;
import com.ssdi.dao.LoginRepository;
import com.ssdi.model.Examiner;
import com.ssdi.model.User;
import com.ssdi.service.LoginService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SpringBootTest
public class LoginServiceTest {

	@Injectable
	private LoginRepository loginRepository;
	
	@Tested
	private LoginService loginService;
	
	@Test
	public void loginServiceTest(User user) {
		Examiner examiner = new Examiner("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword");
		new Expectations() {
			{
				loginRepository.findByEmail(examiner.getEmail());
			}
		};
		
		loginService.login(examiner);
		
	}	
	
}
