package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.LoginRepository;
import com.ssdi.model.User;


@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public User login(User user) {
		User userTryingToLogin=  loginRepository.findByEmail(user.getEmail());
		if(userTryingToLogin!=null) {
			if(userTryingToLogin.getPassword().equals(user.getPassword())) {
				return userTryingToLogin;
			}
		}
		return new User();
	}
	
}
