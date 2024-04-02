package com.allancleiton.workshopmongo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allancleiton.workshopmongo.dto.UserDTO;
import com.allancleiton.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		return ResponseEntity.ok().body(
				userService.findAll()
				.stream()
				.map(x -> new UserDTO(x))
				.collect(Collectors.toList()));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findByID(@PathVariable String id) {
		return ResponseEntity.ok().body(new UserDTO(userService.findByID(id)));	
	}
}
 