package com.varun.auth.domain.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="role")
public class Role {

	@Id
	private String roleId;
	private String name;
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	
}
