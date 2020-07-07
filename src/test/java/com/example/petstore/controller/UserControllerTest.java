package com.example.petstore.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petstore.dto.LoginDto;
import com.example.petstore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	ObjectMapper objectMapper;

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	
	LoginDto loginDto;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		
		loginDto = new LoginDto();
		loginDto.setPassword("sekhar");
		loginDto.setUserName("sekhar");

	}

	

	@Test
	public void loginTest() throws Exception {
		// given
		when(userService.authenticateUser("sekhar", "sekhar")).thenReturn(true);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("logged in successfully")));

		verify(userService).authenticateUser("sekhar", "sekhar");
	}

	@Test
	public void loginTest1() throws Exception {
		// given
		when(userService.authenticateUser("sekhar", "sekhar")).thenReturn(false);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("Credentials are incorrect")));

		verify(userService).authenticateUser("sekhar", "sekhar");
	}

}
