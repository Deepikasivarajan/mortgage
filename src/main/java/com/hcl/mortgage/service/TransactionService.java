package com.hcl.mortgage.service;

import java.util.List;

import com.hcl.mortgage.entity.Transaction;

public interface TransactionService {

	List<Transaction> getAllTransactions(Long accountId);

}
