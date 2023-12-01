package com.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
