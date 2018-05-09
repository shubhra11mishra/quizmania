package com.ssdi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ssdi.model.Examinee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamineeRepository extends CrudRepository<Examinee, Integer> {
	public Examinee findByEmail(String email);

	@Modifying
	@Query("select distinct category from com.ssdi.model.Quiz where status=?1")
	List<String> getQuizCategories(String status);

	public void deleteByEmail(String email);
}
