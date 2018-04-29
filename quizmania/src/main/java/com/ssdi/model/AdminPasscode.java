package com.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class AdminPasscode {
	@Id
	private String passcode;

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
}

