package com.gym.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.gym.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public Customer getCustByphone(String phone);

	public Customer deleteCustomerByphone(String phone);
	
	public Customer findByphone(String phone);

	

	public Customer deleteAllByphone(String phone);




	

}
