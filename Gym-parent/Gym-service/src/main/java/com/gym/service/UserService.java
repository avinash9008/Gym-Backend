package com.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.User;
import com.gym.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		User data = repo.save(user);
		return data;
	}
	   
	

}
