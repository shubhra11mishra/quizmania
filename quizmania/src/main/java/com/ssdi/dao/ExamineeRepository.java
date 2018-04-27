package com.ssdi.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ssdi.model.Examinee;
import com.ssdi.model.Question;
import com.ssdi.model.Quiz;

@Repository
public interface ExamineeRepository extends JpaRepository<Examinee, Integer>{
	public Examinee findByEmail(String email);
	
	@Modifying
	@Query("select distinct category from com.ssdi.model.Quiz")
	List<String> getQuizCategories();
}
