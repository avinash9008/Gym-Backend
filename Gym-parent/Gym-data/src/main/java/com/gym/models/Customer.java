package com.gym.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	@Column
	private String phone;
	private String session;
	private String email;
	private Date joiningDate;
	private String amount;
	
	
	public Customer() {}
	
	

	public Customer(long id, String firstname, String lastname, String phone, String session, String email
			         , Date joiningData, String amount) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.session = session;
		this.email = email;
		this.joiningDate = joiningData;
		this.amount = amount;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getSession() {
		return session;
	}



	public void setSession(String session) {
		this.session = session;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getJoiningDate() {
		return joiningDate;
	}



	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}
    
	
	
	

}
