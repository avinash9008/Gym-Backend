package com.gym.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.models.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {

}
