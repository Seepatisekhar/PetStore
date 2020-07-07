package com.example.petstore.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.OderDao;
import com.example.petstore.dao.UserDao;
import com.example.petstore.dto.OrderResponse;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.Purchase;
import com.example.petstore.model.User;
import com.example.petstore.service.OrderService;
/**
 * @author hemas
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	Log logger = LogFactory.getLog(OrderServiceImpl.class);

	
		@Autowired
		UserDao userDao;
		@Autowired
		OderDao orderDao;
		@Autowired
		PetServiceImpl petServiceImpl;

		@Override
		public OrderResponse orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException {
			logger.info(" Enter correct userId And petId");

			Purchase orderPets = new Purchase();
			OrderResponse orderResponseDto = new OrderResponse();
			Optional<User> user = userDao.findAllByUserId(userId);
			if (!user.isPresent()) {
				throw new InvalidCredentialsException("Enter correct UserId");

			}
			orderPets.setUserId(userId);
			orderPets.setPetId(petId);
			orderPets.setDate(LocalDate.now());
			orderDao.save(orderPets);
			orderResponseDto.setMessage("OrderSuccessfully");
			orderResponseDto.setStatusCode(HttpStatus.OK.value());
			return orderResponseDto;

		}

	}

	


