package com.example.petstore.service;

import com.example.petstore.dto.OrderResponse;
import com.example.petstore.exception.InvalidCredentialsException;

public interface OrderService {

	public OrderResponse orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException;
		

}
