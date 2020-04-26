/**
 * 
 */
package com.varun.auth.models;

import lombok.Data;

/**
 * @author varun
 *
 */

@Data
public class Status {
	
	private String status;
	
	private String errorCode;
	
	private String errorDesc;
	
	private String applicationId;
	
	private String redirectUri;
	

}
