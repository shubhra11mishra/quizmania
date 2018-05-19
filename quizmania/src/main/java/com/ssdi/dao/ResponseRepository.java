package com.ssdi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Attempt;
import com.ssdi.model.Question;
import com.ssdi.model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Question, Integer>,CrudRepository<Question, Integer>{

	public Response save(Response resp);
	
	
	//public List<Response> findByAttemptidOrderByQuestionidAsc(Attempt id);
	
}
