package com.varun.auth.service;

import com.varun.auth.domain.User;


public interface UserService {
	
	void createUser(User user) throws Exception;
	
	User save(User user); 
	

}
