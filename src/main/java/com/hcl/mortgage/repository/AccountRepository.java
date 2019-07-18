package com.hcl.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(String account);

	@Query("Select a from Account a where a.customer.customerId=?1")
	List<Account> findByCustomerId(Long customerId);

	@Query("Select a from Account a where a.customer.customerId=?1 and a.accountType=?2")
	Account findByCustomerIdAndAccountType(Long customerId, String accountType);

}
