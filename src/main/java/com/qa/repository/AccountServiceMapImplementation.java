package com.qa.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.google.gson.Gson;
import com.qa.domain.Account;

@Alternative
@ApplicationScoped
public class AccountServiceMapImplementation implements AccountServiceImplementation {
	
	private Map<Long, Account> accountMap;
	
	public AccountServiceMapImplementation() {
		accountMap = new HashMap<Long, Account>();
	}

	@Override
	public String createAccount(String account) {
		Account aAccount = new Gson().fromJson(account, Account.class);
		if (aAccount == null) {
			return "{\"message\": \"No map found\"}";
		}
		else {
			accountMap.put(aAccount.getID(), aAccount);
			return "{\"message\": \"Account sucessfully added\"}";
		}	
	}

	@Override
	public String findAllAccounts() {
		if (accountMap == null) {
			return "{\"message\": \"No map found\"}";
		}
		else {
			return new Gson().toJson(accountMap);
		}	
	}

	@Override
	public String findAnAccount(long ID) {
		if (accountMap.get(ID) == null) {
			return "{\"message\": \"No Account found\"}";
		}
		else {
			return new Gson().toJson(accountMap.get(ID));
		}	
	}

	@Override
	public String deleteAccount(long ID) {		
		if (accountMap == null) {
			return "{\"message\": \"No map found\"}";
		}
		else {
			accountMap.remove(ID);
			return "{\"message\": \"Account sucessfully deleted\"}";
		}	
	}

	@Override
	public String updateAccountFirstName(String newFirstName, long ID) {
		Account aAccount = accountMap.get(ID);
		if (aAccount == null) {
			return "{\"message\": \"No map found\"}";
		}
		else {
			aAccount.setFirstName(newFirstName);
			return "{\"message\": \"Account sucessfully updated\"}";
		}	
	}

	@Override
	public String updateAccountLastName(String newLastName, long ID) {
		Account aAccount = accountMap.get(ID);
		if (aAccount == null) {
			return "{\"message\": \"No map found\"}";
		}
		else {
			aAccount.setFirstName(newLastName);
			return "{\"message\": \"Account sucessfully updated\"}";
		}
	}

}
