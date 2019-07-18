package com.hcl.mortgage.service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.MortgageRequestDTO;
import com.hcl.mortgage.dto.MortgageResponseDTO;
import com.hcl.mortgage.entity.Account;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.entity.Mortgage;
import com.hcl.mortgage.exception.InvalidEmailException;
import com.hcl.mortgage.exception.InvalidFirstName;
import com.hcl.mortgage.exception.InvalidMiddleName;
import com.hcl.mortgage.exception.InvalidPhoneNumberException;
import com.hcl.mortgage.exception.InvalidSurName;
import com.hcl.mortgage.exception.PropertyCostException;
import com.hcl.mortgage.exception.RestrictedAgeException;
import com.hcl.mortgage.repository.AccountRepository;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.repository.MortgageRepository;

@Service
public class MortgageServiceImpl implements MortgageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageServiceImpl.class);
	@Autowired
	MortgageRepository mortgageRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	Account transactionAccount;
	Account mortgageAccount;

	public MortgageResponseDTO createMortgage(MortgageRequestDTO mortgageRequestDTO) {

		String joinDate = mortgageRequestDTO.getDateOfJoining();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate doj = LocalDate.parse(joinDate, formatter);

		String birthDay = mortgageRequestDTO.getDateOfBirth();
		LocalDate dob = LocalDate.parse(birthDay, formatter);

		if (!validateFirstName(mortgageRequestDTO.getFirstName())) {
			throw new InvalidFirstName();
		}

		if (!validateMiddleName(mortgageRequestDTO.getMiddleName())) {
			throw new InvalidMiddleName();
		}

		if (!validateSurName(mortgageRequestDTO.getSurName())) {
			throw new InvalidSurName();
		}

		if (!validAge(dob)) {
			throw new RestrictedAgeException();
		}

		if (!validPhoneNumber(mortgageRequestDTO.getPhoneNumber())) {
			throw new InvalidPhoneNumberException();
		}
		
		if(!validEmail(mortgageRequestDTO.getEmail())) {
			throw new InvalidEmailException();
		}
		Customer customer = new Customer();
		customer.setLoginId(mortgageRequestDTO.getFirstName() + "25");
		customer.setPassword(generatePassword());
		customer.setCustomerName(mortgageRequestDTO.getFirstName());
		customerRepository.save(customer);

		if (mortgageRequestDTO.getPropertyCost() >= 100000 && mortgageRequestDTO.getDeposit() > 0) {
			transactionAccount = new Account();
			transactionAccount.setAccountNumber("ACC" + accountNumber());
			transactionAccount.setAccountType("Transactional Account");
			transactionAccount.setBalance(mortgageRequestDTO.getPropertyCost() - mortgageRequestDTO.getDeposit());
			transactionAccount.setDate(LocalDate.now());
			transactionAccount.setCustomer(customer);
			accountRepository.save(transactionAccount);

			mortgageAccount = new Account();
			mortgageAccount.setAccountNumber("MRT" + accountNumber());
			mortgageAccount.setAccountType("Mortgage Account");
			mortgageAccount.setBalance(-(mortgageRequestDTO.getPropertyCost() - mortgageRequestDTO.getDeposit()));
			mortgageAccount.setDate(LocalDate.now());
			mortgageAccount.setCustomer(customer);
			accountRepository.save(mortgageAccount);
		} else {
			throw new PropertyCostException();
		}
		Mortgage mortgage = new Mortgage();
		BeanUtils.copyProperties(mortgageRequestDTO, mortgage, "dateOfJoining", "dateOfBirth");
		mortgage.setDateOfJoining(doj);
		mortgage.setDateOfBirth(dob);
		mortgage.setCustomer(customer);
		mortgageRepository.save(mortgage);
		LOGGER.info("Mortage Registered Successfully");
		MortgageResponseDTO mortgageResponseDTO = new MortgageResponseDTO();
		mortgageResponseDTO.setLoginId(customer.getLoginId());
		mortgageResponseDTO.setPassword(customer.getPassword());
		mortgageResponseDTO.setCustomerName(customer.getCustomerName());
		mortgageResponseDTO.setAccountNumber(transactionAccount.getAccountNumber());
		mortgageResponseDTO.setMortgageNumber(mortgageAccount.getAccountNumber());
		return mortgageResponseDTO;

	}

	private boolean validateFirstName(String firstName) {
		String name = ("^[a-zA-Z]*$");
		return firstName.matches(name);
	}

	private boolean validateMiddleName(String middleName) {
		String name = ("^[a-zA-Z]*$");
		return middleName.matches(name);
	}

	private boolean validateSurName(String surName) {
		String name = ("^[a-zA-Z]*$");
		return surName.matches(name);
	}
	
	private boolean validEmail(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return (m.find() && m.group().equals(email));
	}
	
	private boolean validPhoneNumber(Long number) {
		String num = number.toString();
		Pattern p = Pattern.compile("^[0-9]{10}$");
		Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	private boolean validAge(LocalDate birthDate) {
		boolean result = false;
		int birthYear = birthDate.getYear();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int age = year - birthYear;
		if (age > 18) {
			result = true;
		}
		return result;
	}

	public String generatePassword() {
		SecureRandom r = new SecureRandom();
		final String alphaCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String alpha = "abcdefghijklmnopqrstuvwxyz";
		final String numeric = "0123456789";
		final String specialChars = "!@#$%^&*_=+-/";
		int length = 5;
		String dic = alphaCaps + alpha + numeric + specialChars;
		String result = "";
		for (int i = 0; i < length; i++) {
			int index = r.nextInt(dic.length());
			result += dic.charAt(index);
		}

		return result;
	}

	public String accountNumber() {
		Random rand = new Random();
		String number = "";
		for (int i = 0; i < 14; i++) {
			int n = rand.nextInt(10) + 0;
			number += Integer.toString(n);
		}
		return number;

	}

}
