package com.ssdi.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.user.User;

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
