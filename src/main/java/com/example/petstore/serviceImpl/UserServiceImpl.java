package com.example.petstore.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.UserDao;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.User;
import com.example.petstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	/**
	 *
	 */
	@Override
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByUserNameAndPassword(userName, password);
		if (user != null)
			return true;
		throw new InvalidCredentialsException("invalid credentials ");
	}

}
