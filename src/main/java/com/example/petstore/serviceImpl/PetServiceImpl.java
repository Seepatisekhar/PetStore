package com.example.petstore.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PetDao;
import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.dto.PetResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;

/**
 * @author hemas
 *
 */
@Service
public class PetServiceImpl implements PetService {
	Log logger = LogFactory.getLog(PetServiceImpl.class);

	@Autowired
	PetDao petDao;

	@Override
	public PetListResponseDto getPetsByPetName(String petName) throws InvalidCredentialsException {
		logger.info(" Enter correct PetName");

		PetListResponseDto petListResponseDto = new PetListResponseDto();
		Optional<List<Pet>> petDetails = petDao.findAllByPetName(petName);
		if (!petDetails.isPresent()) {

			throw new InvalidCredentialsException(" your request are notFound");
		}

		List<PetResponseDto> petList = petDetails.get().stream().map(pet -> getPetDetailsResponseDto(pet))
				.collect(Collectors.toList());
		petListResponseDto.setMessage(" available pets");
		petListResponseDto.setStatusCode(HttpStatus.OK.value());
		petListResponseDto.setPetResponseDto(petList);
		return petListResponseDto;

	}

	private PetResponseDto getPetDetailsResponseDto(Pet pet) {

		PetResponseDto petDetailsResponse = new PetResponseDto();
		BeanUtils.copyProperties(pet, petDetailsResponse);
		return petDetailsResponse;
	}

}
