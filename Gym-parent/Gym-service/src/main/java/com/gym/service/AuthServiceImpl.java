package com.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gym.dto.SignupRequest;
import com.gym.dto.UserDto;
import com.gym.models.User;
import com.gym.repos.UserRepo;

@Service
public class AuthServiceImpl implements AuthService{
	
	 @Autowired
	    private UserRepo userRepo;

	    @Override
	    public UserDto createUser(SignupRequest signupRequest) {
	        User user = new User();
	        user.setUsername(signupRequest.getUsername());
	        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
	        User createUser = userRepo.save(user);
	        
	        UserDto dto = new UserDto();
	        dto.setPassword(createUser.getPassword());
	        dto.setUsername(createUser.getPassword());
			return dto;
	        
	    	
	    	
	    }

}
