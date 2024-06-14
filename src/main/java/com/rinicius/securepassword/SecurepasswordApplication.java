package com.rinicius.securepassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SecurepasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurepasswordApplication.class, args);
	}

}
