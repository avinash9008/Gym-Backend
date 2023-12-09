package com.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Customer getCustByPhone(String phone) {
		Customer getPhone = repo.getCustByphone( phone);
		return getPhone;
	}
	
	public void  deleteCustomerByphone(String phone) {
		Customer existingCustomer = repo.findByphone(phone);
		if(existingCustomer !=null) {
			repo.delete(existingCustomer);
		}else {
			System.out.println("Customer with phone"+phone+"is not present");
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
