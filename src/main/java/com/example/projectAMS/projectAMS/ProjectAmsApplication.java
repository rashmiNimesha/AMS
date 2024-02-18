package com.example.projectAMS.projectAMS;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectAmsApplication {

	static Logger log = Logger.getLogger(ProjectAmsApplication.class.getName());
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectAmsApplication.class, args);
		log.info("Application started...");
	}

}
