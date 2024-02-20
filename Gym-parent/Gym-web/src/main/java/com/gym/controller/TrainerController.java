package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Trainer;
import com.gym.service.TrainerService;

@RequestMapping("api/trainer")
@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	@PostMapping("/trainer")
	public Trainer saveTrainer(@RequestBody Trainer trainer) {
		Trainer data = service.saveTrainer(trainer);
		return data;
	}
	
	@GetMapping("/get")
	public List<Trainer> getTrainer() {
		List<Trainer> list = service.getTrainers();
		return list;
	}
	
	
	

}
