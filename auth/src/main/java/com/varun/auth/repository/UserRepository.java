/**
 * 
 */
package com.varun.auth.repository;

import com.varun.auth.domain.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	User findByUsername(String username);
	

}
