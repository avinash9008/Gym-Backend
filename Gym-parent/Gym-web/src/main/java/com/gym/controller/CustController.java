package com.gym.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.emailService.EmailService;
import com.gym.models.Customer;
import com.gym.service.CustService;

import jakarta.mail.MessagingException;

@RequestMapping("/api/cust")
@RestController
public class CustController {
	@Autowired
	private EmailService emailService;

	// Example usage
	
	
	@Autowired
	private CustService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("save")
	public Customer saveCust(@RequestBody Customer cust) {
		Customer data = service.saveCust(cust);
		sendEmail(cust.getEmail());
		return data;
	}
	
	@GetMapping("/get")
	public List<Customer> getAllCust(){
		List<Customer> list = service.getAllCust();
		return list;
	}
	
	@GetMapping("/getPhone/{phone}")
	public Customer getCustByPhone(@RequestBody String phone) {
		Customer getPhone = service.getCustByPhone(phone);
		return getPhone;
	}
	
	@DeleteMapping("/deletephone/{}phone")
	public Customer deleteCustomerByphone(String phone) {
		Customer getPhone = service.deleteCustomerByphone(phone);
		return getPhone;
	}
	
	public void sendEmail(String eamil) {
	try {
	    emailService.sendEmail(eamil, "GymRegistration", "Hello,you have successfully registred in to  our GYM");
	    
	} catch (MessagingException e) {
	    // Handle exceptions
	}
	}
}
