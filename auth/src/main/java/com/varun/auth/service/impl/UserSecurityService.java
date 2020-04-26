package com.varun.auth.service.impl;


import com.varun.auth.AuthApplication;
import com.varun.auth.domain.User;
import com.varun.auth.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername("admin");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

}
