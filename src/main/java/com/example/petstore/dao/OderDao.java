package com.example.petstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Purchase;

/**
 * @author hemas
 *
 */
@Repository
public interface OderDao extends CrudRepository<Purchase, Integer> {

	
}
