package com.example.petstore.service;

import com.example.petstore.exception.InvalidCredentialsException;

public interface UserService {

	
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException;
}
