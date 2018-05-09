package com.ssdi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.Attempt;
import com.ssdi.model.Question;

public interface AttemptRepository extends CrudRepository<Attempt, Integer>{
	
	@SuppressWarnings("unchecked")
	public Attempt save(Attempt attempt);
	
	public Attempt findByAttemptID(Integer id);
	
	//@Query("select count * where quizID=?1 and userID=?2")
	//public int countByQuizIDAndUserID(int quizID, int userID);
}
