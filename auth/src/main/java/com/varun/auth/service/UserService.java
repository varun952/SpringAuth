package com.varun.auth.service;

import java.util.List;

import com.varun.auth.domain.User;
import com.varun.auth.models.Status;


public interface UserService {
	
	Status createUser(User user) throws Exception;
	
	User save(User user); 
	
	User findByUsername(String username);
		

}
