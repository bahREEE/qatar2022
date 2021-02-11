package com.example.coupe;

import com.example.coupe.dao.UserRepository;
import com.example.coupe.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoupeApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoupeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User((long) 1, "user1", "myFirstName", "myLastName", "Tunis Bardo", "user@domain.com"));

	}

}
