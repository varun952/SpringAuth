/**
 * 
 */
package com.varun.auth.repository;

/**
 * @author varun
 *
 */

import org.springframework.data.mongodb.repository.MongoRepository;

import com.varun.auth.domain.security.Role;

public interface RoleRepository extends MongoRepository<Role, Long>{
	
	Role findByName(String username);

}
