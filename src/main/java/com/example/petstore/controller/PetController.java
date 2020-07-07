package com.example.petstore.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.PetService;

@RestController
public class PetController {
	@Autowired
	PetService petService;
	private static Log logger = LogFactory.getLog(PetController.class);

	/**
	 * @param petName
	 * @return
	 * @throws InvalidCredentialsException
	 */
	@GetMapping("/pet")
	public ResponseEntity<PetListResponseDto> searchPets(@RequestParam("petName") String petName)
			throws InvalidCredentialsException {
		logger.info("dispalying list of pets");

		PetListResponseDto petDetailsResponse = petService.getPetsByPetName(petName);
		return new ResponseEntity<>(petDetailsResponse, HttpStatus.OK);
	}

}