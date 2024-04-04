package com.allancleiton.workshopmongo.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.allancleiton.workshopmongo.domain.Post;
import com.allancleiton.workshopmongo.domain.User;
import com.allancleiton.workshopmongo.dto.AuthorDTO;
import com.allancleiton.workshopmongo.repositories.PostRepository;
import com.allancleiton.workshopmongo.repositories.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{

	@Autowired
	private UserRepository userR;
	
	@Autowired
	private PostRepository postR;
	
	@Override
	public void run(String... args) throws Exception {
		userR.deleteAll();
		postR.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userR.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDateTime.now().minusHours(3), "Partil viagem", "vou viajar pra são paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDateTime.now().minusHours(3), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		postR.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userR.save(maria);
	}

}
