package com.gym.dto;

public class AuthonticationResponse {
	
	private String jwt;

	public AuthonticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
	public AuthonticationResponse() {}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
