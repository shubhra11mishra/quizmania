package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.AttemptRepository;

@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;

}
