package com.gl.userManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UserManagementAppApplication.class);
		Environment env = app.run(args).getEnvironment();
		String serverPort = env.getProperty("server.port");
		System.out.println("Your application is running at http://localhost:" + serverPort);
	}

}
