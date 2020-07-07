package com.example.petstore.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.dto.PetResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.PetService;
@ExtendWith(MockitoExtension.class)

public class PetsController {

	
	@InjectMocks
	PetController petController;

	@Mock
	PetService petService;

	@Test
	public void findDogDetails() throws InvalidCredentialsException {

		PetResponseDto pets = new PetResponseDto();
		pets.setAge(10);
		pets.setColor("black");
		pets.setGender("m");
		pets.setPetName("Dog");
		pets.setPrice(10000);
		Mockito.when(petService.getPetsByPetName("petName")).thenReturn(null);

		ResponseEntity<PetListResponseDto> responsebusdetailsdto = petController.searchPets("petName");
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}
}
