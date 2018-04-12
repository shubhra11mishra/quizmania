package com.ssdi.model;

import javax.persistence.Entity;

@Entity
public class Examinee extends User {
	public Examinee() {
	}
	
	public Examinee(String email, String password) {
		super(email, password);
	}
	
	public Examinee(String userFirstName, String userLastName, String email, String password, String userType) {
		super(userFirstName, userLastName, email, password, String.valueOf(UserType.EXAMINEE));
	}
}
