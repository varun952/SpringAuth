/**
 * 
 */
package com.varun.auth.startup;

import com.varun.auth.domain.User;
import com.varun.auth.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author varun
 *
 */


@Configuration
public class InitializeDB {
	
	@Bean
	CommandLineRunner initDatabase(UserService userService) throws Exception {
		
		return args -> {
					User user1 = new User();
					user1.setUsername("admin");
					user1.setPassword("admin");
					user1.setEmail("singhvssec@gmail.com");
					userService.createUser(user1);
				};	
	}		
}
