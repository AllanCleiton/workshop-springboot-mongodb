package com.allancleiton.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.allancleiton.workshopmongo.domain.User;
import com.allancleiton.workshopmongo.repositories.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{

	@Autowired
	private UserRepository userR;
	
	@Override
	public void run(String... args) throws Exception {
		userR.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userR.saveAll(Arrays.asList(maria, alex, bob));
	}

}
