package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ssdi.model.User;
import com.ssdi.service.LoginService;

@RestController
@RequestMapping("/quizmania")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(method=RequestMethod.POST, value="/login")
	public User Login(@RequestBody User user) {
		return loginService.login(user);
	}
}
