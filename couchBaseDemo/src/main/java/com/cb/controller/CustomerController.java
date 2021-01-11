package com.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.Customer;
import com.cb.repo.CustomerRepo;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return "customer saved successfully";
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

}

