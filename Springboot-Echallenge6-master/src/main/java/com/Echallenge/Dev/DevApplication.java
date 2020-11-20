package com.Echallenge.Dev;

import com.Echallenge.Dev.classe.Role;
import com.Echallenge.Dev.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	/*
	@Bean
	CommandLineRunner start(UserService userService){


		return args->{
			userService.save( new Role(1,"ADMIN"));
			userService.save( new Role(2,"USER"));


			userService.saveUser("ALALOU" ,"Yassine","17/08/1999", "user1", "1234", "1234");
			userService.addRoleToUser("user1","USER");

			userService.saveUser("ADMIN" ,"Admin","10/10/1990", "admin", "admin", "admin");
			userService.addRoleToUser("admin","ADMIN");


		};
	}

*/

}
