package com.example.petstore.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dto.OrderRequest;
import com.example.petstore.dto.OrderResponse;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	private static Log logger = LogFactory.getLog(OrderController.class);

	/**
	 * @param userId
	 * @param orderRequestDto
	 * @return
	 * @throws InvalidCredentialsException
	 */
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderResponse> orderPets(@PathVariable("userId") int userId, OrderRequest orderRequestDto) throws InvalidCredentialsException {
		logger.info("ordering the pets");

		OrderResponse orderResponseDto = orderService.orderPetsByPetId(userId, orderRequestDto.getPetId());

		return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);

	}

}