package com.ssdi.user;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
