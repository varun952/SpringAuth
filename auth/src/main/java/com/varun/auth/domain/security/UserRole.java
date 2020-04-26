package com.varun.auth.domain.security;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.varun.auth.domain.User;

import lombok.Data;


@Data
@Document(collection="user_roles")
public class UserRole {

	@Id
	private String userRoleId;
	
	private User user;
	
	private Role role;
	
	public UserRole(){}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
}
