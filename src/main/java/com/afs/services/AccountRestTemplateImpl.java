package com.afs.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afs.model.Account;

@Service
@PropertySource("classpath:application.properties")
public class AccountRestTemplateImpl implements AccountRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	@Value("${service.endPoint}")
	private String endPoint;

	public Account[] getAccounts() {
		final String uri = endPoint + "/accounts";
		ResponseEntity<Account[]> accounts = restTemplate.getForEntity(uri, Account[].class);
		Account[] result = accounts.getBody();
		return result;
	}

	public Account getAccount(Long accountNo) {
		final String uri = endPoint + "/accounts/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", accountNo);
		ResponseEntity<Account> result = restTemplate.getForEntity(uri, Account.class);
		return result.getBody();
	}

	public boolean saveOrUpdateAccount(Account account) {
		final String uri = endPoint + "/accounts";
		HttpEntity<Account> entity = new HttpEntity<Account>(account);
		ResponseEntity<Boolean> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Boolean.class);
		return result.getBody();
	}

	public int deleteAccount(Long accountNo) {
		final String uri = endPoint + "/accounts/{id}";
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", accountNo);
		ResponseEntity<Integer> result = restTemplate.exchange(uri, HttpMethod.DELETE, null, Integer.class);
		return result.getBody();
	}

}
