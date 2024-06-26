package com.allancleiton.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allancleiton.workshopmongo.domain.Post;
import com.allancleiton.workshopmongo.repositories.PostRepository;
import com.allancleiton.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public Post findByID(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchByTitle(text);
	}
	
	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
		return repository.searchFull(text, minDate, maxDate.plusDays(1));
	}
}
