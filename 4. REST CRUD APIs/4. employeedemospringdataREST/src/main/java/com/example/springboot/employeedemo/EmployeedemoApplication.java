package com.example.springboot.employeedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeedemoApplication.class, args);
	}

}

// for running in POSTMAN : localhost:8080/employees
// for running in browser: http://localhost:8080/employees