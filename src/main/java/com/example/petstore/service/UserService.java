package com.example.petstore.service;

import com.example.petstore.exception.InvalidCredentialsException;

/**
 * @author hemas
 *
 */
public interface UserService {

	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * @throws InvalidCredentialsException
	 */
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException;
}
