package com.config.main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "Com.config.*")
@SpringBootApplication
public class MainSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootApplication.class, args);
	}

}
