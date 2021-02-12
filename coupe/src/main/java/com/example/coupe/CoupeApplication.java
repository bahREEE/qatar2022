package com.example.coupe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoupeApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(CoupeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//spectateurRepository.save(new Spectateur((long) 1, "user1", "userFirstName", "userLastName", "Tunis","user@domain.com"));
	
	}

}
