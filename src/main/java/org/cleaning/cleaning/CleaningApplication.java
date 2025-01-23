package org.cleaning.cleaning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cleaning API", version = "1.0", description = "Design for managing the Cleaning tasks", 
					contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class CleaningApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleaningApplication.class, args);
	}

}
