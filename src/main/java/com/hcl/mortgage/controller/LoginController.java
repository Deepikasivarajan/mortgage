package com.hcl.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.LoginDTO;
import com.hcl.mortgage.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PutMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		String response = loginService.login(loginDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
