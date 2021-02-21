package com.example.coupe;

import java.time.Instant;

import com.example.coupe.Services.AccountService;
import com.example.coupe.dao.RoleRepository;
import com.example.coupe.entities.MyRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoupeApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(CoupeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		roleRepository.save(new MyRole((long) 1, "ADMIN"));
		roleRepository.save(new MyRole((long) 2, "USER"));

		/*
		accountService.saveUser("user3", "xyxyxy", "xyxyxy", "mail@domain.com", Instant.now(), true);
		accountService.addRoleToUser("user3", "USER");
		*/
	}

}
