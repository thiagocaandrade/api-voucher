package com.getnet.getnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class GetnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetnetApplication.class, args);
	}

}
