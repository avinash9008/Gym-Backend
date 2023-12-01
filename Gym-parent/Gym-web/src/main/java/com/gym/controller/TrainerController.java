package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Trainer;
import com.gym.service.TrainerService;


@RestController
public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	@PostMapping("/trainer")
	public Trainer saveTrainer(@RequestBody Trainer trainer) {
		Trainer data = service.saveTrainer(trainer);
		return data;
	}
	

}
