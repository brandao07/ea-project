package eaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication()
public class EaProjectApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EaProjectApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		app.run(args);
	}
}