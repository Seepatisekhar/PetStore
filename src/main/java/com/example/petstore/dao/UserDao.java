package com.example.petstore.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.User;

/**
 * @author hemas
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

	/**
	 * This method validate user login
	 * 
	 * @param employeeName
	 * @param password
	 * @return User
	 */
	public User findByUserNameAndPassword(String userName, String password);


	public Optional<User> findAllByUserId(int userId);


}