package com.gym.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController()
@CrossOrigin(origins = "http://localhost:4200")

public class TestController {
	
	@GetMapping("/test")
	public String testController() {
		return "welcome";
	}

}
