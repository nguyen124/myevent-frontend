package com.afs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.Account;
import com.afs.services.AccountRestTemplate;

@RestController
public class AccountController {
	@Autowired
	private AccountRestTemplate accountService;

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<Account[]> getAll() {
		Account[] accounts = accountService.getAccounts();
		return new ResponseEntity<Account[]>(accounts, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		Account result = accountService.getAccount(id);
		return new ResponseEntity<Account>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveAccount(@RequestBody Account account, BindingResult result) {
		accountService.saveOrUpdateAccount(account);
		if (result.hasErrors()) {
			System.out.println("Has error return newAccount");
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateAccount(@RequestBody Account account) {
		Boolean result = accountService.saveOrUpdateAccount(account);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("id") Long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
