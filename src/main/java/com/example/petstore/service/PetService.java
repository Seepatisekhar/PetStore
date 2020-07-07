package com.example.petstore.service;


import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;


/**
 * @author hemas
 *
 */
public interface PetService {

	/**
	 * @param petName
	 * @return
	 * @throws InvalidCredentialsException
	 */
	PetListResponseDto getPetsByPetName(String petName) throws InvalidCredentialsException;

	
	
}
