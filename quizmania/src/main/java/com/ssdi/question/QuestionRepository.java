package com.ssdi.question;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.user.User;

public interface QuestionRepository extends CrudRepository<User, Integer>{

	public Question save(Question question);
	
}
