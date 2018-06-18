package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.qa.domain.Account;

@Transactional(SUPPORTS)
public class AccountServiceDBImplementation {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account aAccount = new Gson().fromJson(account, Account.class);
		manager.persist(aAccount);
		return "{\"message\": \"Account sucessfully added\"}";
	}
	
	public String findAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT * FROM Account", Account.class);
		if (query.getResultList() == null) {
			return "{\"message\": \"No accounts found\"}";
		}
		else {
			return new Gson().toJson(query.getResultList());
		}	
	}
	
	public String findAnAccount(long ID) {	
		if (manager.find(Account.class, ID) == null) {
			return "{\"message\": \"No account found\"}";
		}
		else {
			return new Gson().toJson(manager.find(Account.class, ID));
		}
		
	}
		
	public String deleteAccount(String accountNumber) {
		manager.remove(accountNumber);
		return "{\"message\": \"Account sucessfully deleted\"}";
	}
	
	public String updateAccountFirstName(String newFirstName, long ID) {
		Account account = manager.find(Account.class, ID);
		account.setFirstName(newFirstName);		
		return "{\"message\": \"Account sucessfully edited\"}";
	}
	
	public String updateAccountLastName(String newLastName, long ID) {
		Account account = manager.find(Account.class, ID);
		account.setLastName(newLastName);		
		return "{\"message\": \"Account sucessfully edited\"}";
	}
	
}
