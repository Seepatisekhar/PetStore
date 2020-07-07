package com.example.petstore.service;

import com.example.petstore.dto.OrderResponse;
import com.example.petstore.exception.InvalidCredentialsException;

/**
 * @author hemas
 *
 */

public interface OrderService {

	/**
	 * @param userId
	 * @param petId
	 * @return
	 * @throws InvalidCredentialsException
	 */
	public OrderResponse orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException;
		

}
