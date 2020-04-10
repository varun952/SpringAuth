package com.varun.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.auth.domain.User;
import com.varun.auth.repository.UserRepository;

@RestController
@RequestMapping("/app")
public class UserController {
	
	@Autowired
	private UserRepository userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createuser(@RequestBody User user) {
		  try {
		    User _user = userService.save(user);
		    return new ResponseEntity<>(_user, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		  }
		}

}
