package com.hcl.mortgage.service;

import java.util.List;

import com.hcl.mortgage.entity.Account;

public interface AccountService  {

	Account findByAccountNumber(String fromAccount);

	Account save(Account account);

	List<Account> getAllAccounts();

	List<Account> findById(Long customerId);

	Account getTransactionalAccount(Long customerId, String string);

	Account getMortgageAccount(Long customerId, String string);

}
