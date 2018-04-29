package com.ssdi.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Examinee extends User {
	
	public Examinee() {
	}


	public Examinee(String email, String password) {
		super(email, password);
	}
	
	public Examinee(String userFirstName, String userLastName, String email, String password) {
		super(userFirstName, userLastName, email, password, String.valueOf(UserType.EXAMINEE));
	}

	
	
}
