package com.gym.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
