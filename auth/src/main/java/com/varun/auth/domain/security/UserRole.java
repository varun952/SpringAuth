package com.varun.auth.domain.security;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.varun.auth.domain.User;


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


	public String getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
