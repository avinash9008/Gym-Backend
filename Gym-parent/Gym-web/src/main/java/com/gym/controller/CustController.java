package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Customer;
import com.gym.service.CustService;

@RequestMapping("/api")
@RestController
public class CustController {
	
	@Autowired
	private CustService service;
	
	@PostMapping("save")
	public Customer saveCust(@RequestBody Customer cust) {
		Customer data = service.saveCust(cust);
		return data;
	}
	
	@GetMapping("/get")
	public List<Customer> getAllCust(){
		List<Customer> list = service.getAllCust();
		return list;
	}

}
