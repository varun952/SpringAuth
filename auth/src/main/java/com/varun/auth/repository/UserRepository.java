/**
 * 
 */
package com.varun.auth.repository;

import java.util.List;

/**
 * @author varun
 *
 */

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varun.auth.domain.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	List<User> findByUserId(String username);
	

}
