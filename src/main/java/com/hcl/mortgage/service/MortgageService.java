package com.hcl.mortgage.service;

import com.hcl.mortgage.dto.MortgageRequestDTO;
import com.hcl.mortgage.dto.MortgageResponseDTO;

public interface MortgageService {

	MortgageResponseDTO createMortgage(MortgageRequestDTO mortgageRequestDTO);

	String generatePassword();

	String accountNumber();

}
