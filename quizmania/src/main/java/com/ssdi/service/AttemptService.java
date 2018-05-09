package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.AttemptRepository;
import com.ssdi.model.Attempt;

@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;

	/**public int countByQuizIDAndUserID(int quizID, int userID) {
		return attemptRepository.countByQuizIDAndUserID(quizID, userID);
	}
*/
	
	public Attempt save(Attempt newAttempt) {
		return attemptRepository.save(newAttempt);
	}

}
