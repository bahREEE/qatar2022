package com.example.coupe;

import com.example.coupe.dao.RoleRepository;
import com.example.coupe.entities.ERole;
import com.example.coupe.entities.MyRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class CoupeApplication implements CommandLineRunner {

@Autowired
private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoupeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//roleRepository.save(new MyRole(null, ERole.ROLE_ADMIN));
		//roleRepository.save(new MyRole(null,ERole.ROLE_USER));
	}

}
