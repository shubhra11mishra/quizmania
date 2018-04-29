package com.ssdi.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class ExamineeTest {

	@Test
	public void testUser(){
		Examinee user = new Examinee();
		
		new Verifications(){{
			assertEquals(null, user.getEmail());
		}};
		
		user.setEmail("testEmail@testDomain.com");
		
		new Verifications(){{
			assertEquals("testEmail@testDomain.com", user.getEmail());
		}};
	}
	
}
