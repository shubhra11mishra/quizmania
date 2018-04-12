package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.User;
import com.ssdi.service.UserService;

@RestController
@RequestMapping("/quizmania/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.POST, value="/login")
	public User userLogin(@RequestBody User user){
		return userService.getUserByEmail(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public User registerUser(@RequestBody User user) {
		return userService.createUser(user);
	}

}
