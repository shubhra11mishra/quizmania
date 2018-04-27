package com.ssdi.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Question;
import com.ssdi.model.Quiz;
import com.ssdi.model.User;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	public Quiz save(Quiz quiz);
	
	
	@Modifying
	@Query("update Quiz u set u.status=?1 where u.quizID = ?2")
	void setQuizStatus(String status, Integer quizid);
	
	public List<Quiz> findByStatusOrderByCategoryAsc(String status);


	public List<Quiz> findByAuthorOrderByTitleAsc(User user);
	
	@Modifying
	@Query("select u from Quiz u where category=?1 and status='approved'")
	public Collection<Quiz> findCategory(String id);
	
}
