/** Not necessary to test SPring JPA repository 
package com.ssdi.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.model.Admin;

import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SpringBootTest 
public class AdminRepositoryTest {
	
AdminRepository adminRepository;
	//
	@Test
	public void save() {
		Admin admin = new Admin("testFirstName", "testLastName", "email@test.com", "testPassword", "testPasscode");
		//adminRepository.save(admin);
	}
	
}
*/
