package com.example.petstore.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petstore.dao.UserDao;
import com.example.petstore.dto.LoginDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.User;
import com.example.petstore.serviceImpl.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	User user;

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	LoginDto loginDto;

	@BeforeEach
	public void setUp() {

		loginDto = new 	LoginDto();
		loginDto.setUserName("sekhar");
		loginDto.setPassword("sekhar");
		
	}

	
	@Test
	public void authenticateTest1() throws InvalidCredentialsException {
		// given
		User user = new User();
		user.setUserName("sekhar");
		user.setPassword("sekhar");

		when(userDao.findByUserNameAndPassword("sekhar", "sekhar")).thenReturn(user);

		// when
		Boolean isExists = userServiceImpl.authenticateUser("sekhar", "sekhar");

		// then
		verify(userDao).findByUserNameAndPassword("sekhar", "sekhar");
		assertTrue(isExists);
	}

	@Test
	public void authenticateTest2() {
		// given
		User user = new User();
		user.setUserName("sekhar");
		user.setPassword("sekhar");

		when(userDao.findByUserNameAndPassword("sekhar", "sekhar")).thenReturn(null);

		// when

		// then
		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser("sekhar", "sekhar"));
	}

}
