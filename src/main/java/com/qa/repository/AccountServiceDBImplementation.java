package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.*;

import java.util.List;

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
	
	public List<Account> findAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT * FROM Account", Account.class);
		return query.getResultList();
	}
	
	public Account findAnAccount(long ID) {	
		return manager.find(Account.class, ID);
	}
		
	public String deleteAccount(String accountNumber) {
		manager.remove(accountNumber);
		return "{\"message\": \"Account sucessfully deleted\"}";
	}
	
	public String updateAccountFirstName(String newFirstName, long ID) {
		Account account = findAnAccount(ID);
		account.setFirstName(newFirstName);		
		return "{\"message\": \"Account sucessfully edited\"}";
	}
	
	public String updateAccountLastName(String newLastName, long ID) {
		Account account = findAnAccount(ID);
		account.setLastName(newLastName);		
		return "{\"message\": \"Account sucessfully edited\"}";
	}
	
}
