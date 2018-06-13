package com.qa.application;

import com.qa.domain.Account;
import com.qa.service.AccountService;
import com.qa.util.JSONUtil;

public class App {

	public static void main(String[] args) {
		AccountService service = new AccountService();
		JSONUtil util = new JSONUtil();
		Account joeBloggs = new Account("Joe", "Bloggs", "1234");
		Account janeBloggs = new Account("Jane", "Bloggs", "1234");
		Account badAccount = new Account("Bad", "Account", "9999");
		service.addAccountFromMap(joeBloggs);
		service.addAccountFromMap(janeBloggs);
		service.addAccountFromMap(badAccount);
		String mapAsJSON = util.getJSONForObject(service.getAccountMap());
		System.out.println("This is the account map as JSON " + mapAsJSON);

	}

}
