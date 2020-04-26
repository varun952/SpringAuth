package com.varun.auth.startup;

/**
 * @author varun
 *
 */

@FunctionalInterface
public interface CommandLineRunner {
	
	public void run(String... args);
	
}
