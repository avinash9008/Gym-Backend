package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.User;
import com.gym.service.UserService;

@RequestMapping("/api/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("sss")
	public User saveUser(User user) {
		User data = service.saveUser(user);
		return data;
	}

}
