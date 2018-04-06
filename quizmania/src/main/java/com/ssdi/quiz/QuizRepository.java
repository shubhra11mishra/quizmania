package com.ssdi.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.user.User;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	public Quiz save(Quiz quiz);
	
}
