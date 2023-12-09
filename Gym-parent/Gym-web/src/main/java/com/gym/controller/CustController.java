package com.gym.controller;

import java.util.List;  

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

import com.gym.models.Customer;
import com.gym.service.CustService;

@RequestMapping("/api/cust")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustController {
	
	@Autowired
	private CustService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
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
	
    @PutMapping("/update/{phone}")

	public ResponseEntity<Customer> updateCustomerByPhone( @PathVariable String phone, @RequestBody Customer updatedCustomerData
    ) {
        Customer updatedCustomer = service.updateCustByphone(phone, updatedCustomerData);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
			
		} 
	
//	@PutMapping("/update/{firstname}/{phone}")
//	public Customer updateCustByFirstnameAndPhone(String firstname, String phone) {
//		Customer getData = service.updateCustByFirstnameAndPhone(firstname, phone) ;
//		return getData;
//	}


