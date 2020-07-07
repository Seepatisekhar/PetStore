package com.example.petstore.service;


import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;


public interface PetService {

	PetListResponseDto getPetsByPetName(String petName) throws InvalidCredentialsException;

	
	
}
