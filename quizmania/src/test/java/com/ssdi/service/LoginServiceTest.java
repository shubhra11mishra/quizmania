package com.ssdi.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ssdi.dao.AdminRepository;
import com.ssdi.dao.LoginRepository;
import com.ssdi.model.Admin;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class LoginServiceTest {
	
	@Injectable
	private LoginRepository loginRepository;
	
	@Tested
	LoginService loginService;
	
	@Test
	public void LoginServiceTest() {
		
	Admin testAdmin = new Admin("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword",
				"123456");
	
	new Expectations() {
		{
			loginRepository.findByEmail(testAdmin.getEmail());
		}
	};
	
	loginService.login(testAdmin);
	
	}
	
}
