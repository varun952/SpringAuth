package com.varun.auth.service.impl;


import java.util.List;

import com.varun.auth.AuthApplication;
import com.varun.auth.domain.User;
import com.varun.auth.models.Status;
import com.varun.auth.repository.UserRepository;
import com.varun.auth.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(AuthApplication.class);
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public Status createUser(User user) {
		
		String errorDesc = null;
		String errorCode = null;
		String status = null;
		
		Status createStatus = new Status();
		
		User localuser = userRepository.findByUsername(user.getUsername());		
		
		if (localuser != null) {
			errorDesc = "user "+user.getUsername()+" already exists";
			errorCode = "ERR_USER_ALREADY_EXISTS";
			status = "FAILED";
		}else{
			User localUser = userRepository.save(user);
			status = "CREATED";
		}
		return createStatus;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}


}
