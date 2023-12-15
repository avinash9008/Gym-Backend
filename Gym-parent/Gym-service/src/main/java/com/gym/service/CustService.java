package com.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repos.CustomerRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustService {
	
	@Autowired
	private CustomerRepo repo;
	
	public Customer saveCust(Customer cust) {
		Customer data = repo.save(cust);
		return data;
	}
	
	public List<Customer> getAllCust(){
		List<Customer> list = repo.findAll();
		return list;
	}
	
	public Customer getCustByphone(String phone) {
		Customer getPhone = repo.findByphone(phone);
		return getPhone;
	}
	
	public void deleteAllByphone(String phone) {
		
		Customer customer = repo.getCustByphone(phone);
		
		if(customer != null) {
			 repo.delete(customer);
		}else {
			System.out.println("customer with"+phone+"this no is not present");
		}
	}
	
	public Customer updateCustomerByPhone(String phone, Customer updatedData) {
		Customer existingCustomer = repo.findByphone(phone);
		
		if(existingCustomer != null) {
			existingCustomer.setFirstname(updatedData.getFirstname());
			existingCustomer.setLastname(updatedData.getLastname());
			existingCustomer.setPhone(updatedData.getPhone() );
			existingCustomer.setSession(updatedData.getSession());
			existingCustomer.setJoiningDate(updatedData.getJoiningDate());
			existingCustomer.setAmount(updatedData.getAmount());
			existingCustomer.setEmail(updatedData.getEmail());
			
			return repo.save(existingCustomer);
		}
		else {
			return null;
		}
		
	}

}
