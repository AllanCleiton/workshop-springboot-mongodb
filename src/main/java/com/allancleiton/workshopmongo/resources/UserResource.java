package com.allancleiton.workshopmongo.resources;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allancleiton.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(
				Arrays.asList(
						new User("1", "maria silva", "maria@gmail.com"), 
						new User("2", "Alex Greem", "alex@gmail.com")));
	}
}
 