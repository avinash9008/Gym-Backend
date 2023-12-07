package com.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.gym.models.Trainer;
import com.gym.repos.TrainerRepo;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepo repo;
	
	public Trainer saveTrainer(Trainer trainer) {
		Trainer data = repo.save(trainer);
		return data;
	}
	
	
	public List<Trainer> getTrainers(){
		List<Trainer> list = repo.findAll();
		return list;
	}
}
