package com.example.petstore.dto;

import java.util.List;

public class PetListResponseDto {

	private String message;
	private int statusCode;
	List<PetResponseDto> petResponseDto;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<PetResponseDto> getPetResponseDto() {
		return petResponseDto;
	}

	public void setPetResponseDto(List<PetResponseDto> petResponseDto) {
		this.petResponseDto = petResponseDto;
	}

}
