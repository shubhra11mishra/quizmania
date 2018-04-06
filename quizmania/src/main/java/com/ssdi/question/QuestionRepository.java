package com.ssdi.question;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.quiz.Quiz;
import com.ssdi.user.User;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>,CrudRepository<Question, Integer>{

	public Question save(Question question);
	
	
	public List<Question> findByQuizID(Quiz id);
	
}
