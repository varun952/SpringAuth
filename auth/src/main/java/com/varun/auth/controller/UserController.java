package com.varun.auth.controller;

import com.varun.auth.AuthApplication;
import com.varun.auth.domain.User;
import com.varun.auth.models.Status;
import com.varun.auth.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(AuthApplication.class);

	Status status = null;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public String postLogin(@RequestParam(value = "username") String userEmail,
			@RequestParam(value = "password") String userPassword) {
		logger.debug(userEmail + " and " + userPassword);
		boolean loginResult = securityService.login(userEmail, userPassword);
		return (loginResult ? "redirect:/secure/home" : "redirect:/login?error=true");
	}

	@PostMapping("/users")
	public ResponseEntity<User> createuser(@RequestBody User user) {
		try {
			status = userService.createUser(user);

			if (status.getStatus() == "CREATED") {
				User newUser = userService.findByUsername(user.getUsername());
			}
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
