package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id 
	@GeneratedValue
	private long ID;
	private String firstName;
	private String lastName;
	private String accountNumber;

	public Account(String firstName, String secondName, String accountNumber) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.accountNumber = accountNumber;
	}

	public long getID() {
		return ID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
