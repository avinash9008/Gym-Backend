package com.gym.controller;

import java.util.List; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.emailService.EmailService;
import com.gym.models.Customer;
import com.gym.repos.CustomerRepo;
import com.gym.service.CustService;

import jakarta.mail.MessagingException;

@RequestMapping("/api/cust")
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CustController {
	
	private static final String PHONE_NUMBER_REGEX = "^[+]?[0-9]{8,}$"; // Modify the regex as needed
	
	@Autowired
	private EmailService emailService;

	// Example usage
	
	
	@Autowired
	private CustService service;
	
	@Autowired
	private CustomerRepo repo;
	
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
	    public ResponseEntity<?> getCustByphone(@PathVariable String phone) {
	        // Validate phone number format using Regex
	        if (!isValidPhoneNumber(phone)) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number format");
	        }

	        Customer customer = repo.findByphone(phone);
	        if (customer != null) {
	            return ResponseEntity.ok(customer); // Return customer if found
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found"); // Return 404 if customer not found
	        }
	    }
	
	
	@DeleteMapping("/delete/{phone}")
public String deleteAllByphone(@PathVariable String phone) {
		if(isValidPhoneNumber(phone)) {
			Customer customer = repo.getCustByphone(phone);
			if(customer!=null) {
				repo.delete(customer);
			}else {
				return "data is not existed";
			}
		}else {
			return "phone number is not valid";
		}
		return "successfully deletd";
		
		
		
	}
	
	public boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
	
	@PutMapping("/update/{phone}")
	@CrossOrigin(origins = "http://localhost:4200/updateCustomer/9008284002")

	public ResponseEntity<Customer> updateCustomer(@PathVariable String phone, @RequestBody Customer updatedCutomer) {
		Customer updatedCustomer = service.updateCustomerByPhone(phone, updatedCutomer);
		if(updatedCustomer != null) {
			return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
		}else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	public void sendEmail(String eamil) {
	try {
	    emailService.sendEmail(eamil, "GymRegistration", "Hello,you have successfully registred in to  our GYM");
	    
	} catch (MessagingException e) {
	    // Handle exceptions
	}
	}
}
