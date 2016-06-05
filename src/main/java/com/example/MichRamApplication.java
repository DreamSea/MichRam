package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="connection, controllers")
public class MichRamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MichRamApplication.class, args);
	}
}
