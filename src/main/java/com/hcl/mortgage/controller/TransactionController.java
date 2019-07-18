package com.hcl.mortgage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.service.TransactionService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@GetMapping("/allTransactions/{accountId}")
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable Long accountId) {
		List<Transaction> transactionList = transactionService.getAllTransactions(accountId);
		LOGGER.info("Transaction Statements");
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

}
