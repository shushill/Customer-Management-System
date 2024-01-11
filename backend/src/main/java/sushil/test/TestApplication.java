package sushil.test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Customer Management Microservice Assignment for ERP System",
				description = "Customer Management Service API documentation \n" +
						"User name and password is mentioned in application.properties",
				version = "v1.0",
				contact = @Contact(
						name = "Sushil verma"
				)
		)
)
public class TestApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);
	}

}
