package io.reki;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reki.components.View;

@SpringBootApplication
public class ExerciciDausApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciciDausApplication.class, args);
		View vista = new View();
		/*
		 * ThrowDices tirada = new ThrowDices(3); tirada.tira();
		 */
	}

}
