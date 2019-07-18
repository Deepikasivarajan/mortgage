package com.hcl.mortgage.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Transaction;
import com.hcl.mortgage.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionRepository transactionRepository;

	public String monthlyPayment() {
		List<Account> getAllAccounts = accountService.getAllAccounts();
		if (!(getAllAccounts.isEmpty())) {
			Long previousCustomerId = 0l;
			Long currentCustomerId = 0l;
			for (Account account : getAllAccounts) {
				Long customerId = account.getCustomer().getCustomerId();
				currentCustomerId = customerId;
				if (currentCustomerId != previousCustomerId) {
					Account transactionalAccount = accountService.getTransactionalAccount(customerId,
							"Transactional Account");
					Account mortgageAccount = accountService.getMortgageAccount(customerId, "Mortgage Account");
					if (transactionalAccount.getBalance() >= 200) {
						if (mortgageAccount.getBalance() < 0) {
							Double transactionalAccountBalance = transactionalAccount.getBalance() - 200;
							Double mortgageAccountBalance = mortgageAccount.getBalance() + 200;
							transactionalAccount.setBalance(transactionalAccountBalance);
							mortgageAccount.setBalance(mortgageAccountBalance);
							accountService.save(transactionalAccount);
							accountService.save(mortgageAccount);

							Transaction transactionInTransactional = new Transaction();
							Transaction transactionInMortgage = new Transaction();

							transactionInTransactional.setAccount(transactionalAccount);
							transactionInTransactional.setAmount(200d);
							transactionInTransactional.setComments("monthly payment");
							transactionInTransactional.setFromAccount(transactionalAccount.getAccountNumber());
							transactionInTransactional.setToAccount(mortgageAccount.getAccountNumber());
							transactionInTransactional.setTransactionDate(LocalDate.now());
							transactionInTransactional.setTransactionTime(LocalTime.now());
							transactionInTransactional.setTransactionType("debit");

							transactionInMortgage.setAccount(mortgageAccount);
							transactionInMortgage.setAmount(200d);
							transactionInMortgage.setComments("monthly payment");
							transactionInMortgage.setFromAccount(transactionalAccount.getAccountNumber());
							transactionInMortgage.setToAccount(mortgageAccount.getAccountNumber());
							transactionInMortgage.setTransactionDate(LocalDate.now());
							transactionInMortgage.setTransactionTime(LocalTime.now());
							transactionInMortgage.setTransactionType("credit");

							transactionRepository.save(transactionInTransactional);
							transactionRepository.save(transactionInMortgage);

							previousCustomerId = currentCustomerId;
						}
					}
				}
			}

			return "Success";
		} else {
			return "failed";
		}
	}

	@Scheduled(fixedRate = 1 * 60 * 1000)
	public void testSchedule() {
		monthlyPayment();

	}

	public List<Transaction> getAllTransactions(Long accountId) {
		List<Transaction> allTransactions = transactionRepository.findByAccountId(accountId);
		return allTransactions;
	}
}