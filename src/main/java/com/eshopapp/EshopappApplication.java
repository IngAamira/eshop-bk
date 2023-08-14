package com.eshopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EshopappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopappApplication.class, args);
	}

}
