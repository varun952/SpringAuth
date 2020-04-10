package com.varun.auth.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.auth.domain.User;
import com.varun.auth.repository.RoleRepository;
import com.varun.auth.repository.UserRepository;
import com.varun.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	/*
	 * @Override public User createUser(User user, Set<UserRole> userRoles) { User
	 * localUser = userRepository.findByUsername(user.getUsername());
	 * 
	 * if (localUser != null) {
	 * LOG.info("user {} already exists. Nothing will be done.",
	 * user.getUsername()); } else { for (UserRole ur : userRoles) {
	 * roleRepository.save(ur.getRole()); }
	 * 
	 * user.getUserRoles().addAll(userRoles); localUser = userRepository.save(user);
	 * }
	 * 
	 * return localUser; }
	 */	
	@Override
	public void createUser(User user) {
		List<User> localuser = userRepository.findByUserId(user.getUsername());
		
		LOG.info(":::::::: user {} found.", localuser);
		
		
		if (!localuser.isEmpty()) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		}else{
			LOG.info("creating new user '{}'.", user.getUsername());
			User localUser = userRepository.save(user);
		}
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
