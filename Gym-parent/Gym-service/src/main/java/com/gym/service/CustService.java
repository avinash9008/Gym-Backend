package com.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repos.CustomerRepo;

@Service
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
	
	public Customer  deleteCustomerByphone(String phone) {
		Customer getPhone = repo.deleteCustByPhone(phone);
		return getPhone;
	}

	public Customer updateCustByphone(String phone, Customer updatedCustomerData) {
		Customer existingCustomer = repo.findByphone(phone);
		if(existingCustomer != null) {
			existingCustomer.setFirstname(updatedCustomerData.getFirstname());
			existingCustomer.setLastname(updatedCustomerData.getLastname());
			existingCustomer.setPhone(updatedCustomerData.getPhone());
            existingCustomer.setSession(updatedCustomerData.getSession());
            existingCustomer.setJoiningDate(updatedCustomerData.getJoiningDate());
            existingCustomer.setAmount(updatedCustomerData.getAmount());
            
            return repo.save(existingCustomer);
		}else {
		return null;
		}
	}
	
	public Customer updateCustByFirstnameAndPhone(String firstname, String phone) {
		Customer getData = repo.getCustByFirstnameAndPhone(firstname, phone) ;
		return getData;
	}

}
