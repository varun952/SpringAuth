package com.varun.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.varun.auth.domain.User;
import com.varun.auth.service.UserService;
import com.varun.auth.utility.SecurityUtility;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner{
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthApplication.class);
		
	@Autowired
	private UserService userService;
	

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("singhvssec@gmail.com");
		
		LOG.info("::::::: creating default user ::: {} ",user1);
		
		userService.createUser(user1);
		
	}

}
