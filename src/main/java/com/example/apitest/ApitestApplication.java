package com.example.apitest;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ApitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApitestApplication.class, args);
	}

}
