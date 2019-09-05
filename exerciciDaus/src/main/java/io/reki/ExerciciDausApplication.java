package io.reki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciciDausApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciciDausApplication.class, args);
		
		ThrowDices tirada = new ThrowDices(3);
		
		tirada.tira();
	}

}
