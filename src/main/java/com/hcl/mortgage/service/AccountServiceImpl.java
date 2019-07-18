package com.hcl.mortgage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.exception.AccountNotFoundException;
import com.hcl.mortgage.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();

		return accounts;

	}

	public Account getTransactionalAccount(Long customerId, String accountType) {
		Account transactionalAccount = accountRepository.findByCustomerIdAndAccountType(customerId, accountType);

		return transactionalAccount;

	}

	public Account getMortgageAccount(Long customerId, String accountType) {
		Account mortgageAccount = accountRepository.findByCustomerIdAndAccountType(customerId, accountType);

		return mortgageAccount;

	}

	public List<Account> findById(Long customerId) {
		List<Account> userAccounts = accountRepository.findByCustomerId(customerId);
		if (!(userAccounts.isEmpty())) {
			return userAccounts;
		} else {
			throw new AccountNotFoundException();
		}
	}

	public Account findByAccountNumber(String account) {
		Account responseAcc = accountRepository.findByAccountNumber(account);
		if (responseAcc != null) {
			return responseAcc;
		} else {
			throw new AccountNotFoundException();
		}
	}

	public Account save(Account account) {
		Account responseAccount = accountRepository.save(account);
		if (responseAccount != null) {
			return responseAccount;
		} else {
			throw new AccountNotFoundException();
		}
	}

}
