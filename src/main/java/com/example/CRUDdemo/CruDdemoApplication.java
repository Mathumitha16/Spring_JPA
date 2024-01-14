package com.example.CRUDdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruDdemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			System.out.println("Hello World");
		};
	}

}
