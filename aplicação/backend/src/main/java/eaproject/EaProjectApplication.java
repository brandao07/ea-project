package eaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EaProjectApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EaProjectApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "7000"));
		app.run(args);
	}
}
