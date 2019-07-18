package com.hcl.mortgage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.MortgageRequestDTO;
import com.hcl.mortgage.dto.MortgageResponseDTO;
import com.hcl.mortgage.service.MortgageService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class MortgageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageController.class);
	@Autowired
	MortgageService mortgageService;
	
	@PostMapping("/mortgage")
	public ResponseEntity<MortgageResponseDTO> createMortgage(@RequestBody MortgageRequestDTO mortgageRequestDTO) {
		LOGGER.info("inside mortgage");
		MortgageResponseDTO mortgageResponseDTO = mortgageService.createMortgage(mortgageRequestDTO);
		return new ResponseEntity<>(mortgageResponseDTO, HttpStatus.CREATED);
	}
	
}
