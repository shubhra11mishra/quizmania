package com.ssdi.model;

import javax.persistence.Entity;


@Entity
public class Examiner extends User{

	public Examiner() {
	}
	
	public Examiner(String email, String password) {
		super(email, password);
	}
	
	public Examiner(String userFirstName, String userLastName, String email, String password) {
		super(userFirstName, userLastName, email, password, String.valueOf(UserType.EXAMINER));
	}
	
}
