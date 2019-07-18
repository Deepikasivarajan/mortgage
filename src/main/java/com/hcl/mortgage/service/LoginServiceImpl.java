package com.hcl.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.LoginDTO;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.exception.UserNotFoundException;
import com.hcl.mortgage.repository.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String login(LoginDTO loginDTO) {
		Customer customer = customerRepository.findByLoginIdAndPassword(loginDTO.getLoginId(),loginDTO.getPassword());
		if(customer!=null) {
			return "login successfull";
		}else {
			throw new UserNotFoundException();
		}
		
	}

}
