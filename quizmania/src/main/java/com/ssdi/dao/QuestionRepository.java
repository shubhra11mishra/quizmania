package com.ssdi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Question;
import com.ssdi.model.Quiz;
import com.ssdi.model.User;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>,CrudRepository<Question, Integer>{

	public Question save(Question question);
	
	
	public List<Question> findByQuizIDOrderByNumberAsc(Quiz id);
	
}
