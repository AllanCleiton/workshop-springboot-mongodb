package com.allancleiton.workshopmongo.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.allancleiton.workshopmongo.domain.Post;
import com.allancleiton.workshopmongo.domain.User;
import com.allancleiton.workshopmongo.dto.AuthorDTO;
import com.allancleiton.workshopmongo.dto.CommentDTO;
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
		
		Post post1 = new Post(null, LocalDateTime.parse("27/08/2018 15:52", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "Partil viagem", "vou viajar pra são paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDateTime.parse("20/07/2022 13:11", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("2018-03-21"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.parse("2018-03-22"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", LocalDate.parse("2018-03-23"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		
		postR.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userR.save(maria);
	}

}
