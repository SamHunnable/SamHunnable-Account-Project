package com.qa.repository;

public interface AccountServiceImplementation {

	
	public String createAccount(String account);
	
	public String findAllAccounts();
	
	public String findAnAccount(long ID);
		
	public String deleteAccount(long ID);
	
	public String updateAccountFirstName(String newFirstName, long ID);
	
	public String updateAccountLastName(String newLastName, long ID);
}
