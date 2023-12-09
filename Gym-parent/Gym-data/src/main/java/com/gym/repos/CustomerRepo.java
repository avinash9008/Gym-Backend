package com.gym.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public Customer getCustByphone(String phone);

	public Customer deleteCustByPhone(String phone);

	public Customer findByphone(String phone);
	
	public Customer getCustByFirstnameAndPhone(String firstname, String phone);


}
