package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.UserRepository;
import com.ssdi.model.User;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUserByEmail(User user){
		return userRepository.findByEmail(user.getEmail());
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Integer id) {
		return userRepository.findByUserID(id);
	}
}
