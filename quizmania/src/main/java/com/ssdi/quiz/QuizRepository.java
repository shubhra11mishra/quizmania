package com.ssdi.quiz;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.user.User;

public interface QuizRepository extends CrudRepository<User, Integer>{

	public Quiz save(Quiz quiz);
	
}
