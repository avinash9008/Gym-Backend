package com.gym.service;

import com.gym.dto.SignupRequest;
import com.gym.dto.UserDto;

public interface AuthService {

	UserDto createUser(SignupRequest signupRequest);

}
