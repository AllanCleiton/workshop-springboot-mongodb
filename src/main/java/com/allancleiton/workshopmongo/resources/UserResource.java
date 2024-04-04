package com.allancleiton.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allancleiton.workshopmongo.domain.User;
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
		return ResponseEntity.ok().body(new UserDTO(userService.findByID(id)));	  //OK() -> 200
 	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = userService.insert(userService.fromDTO(objDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		User obj = userService.fromDTO(objDto);
		obj.setId(id);
		obj = userService.upDate(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();  //noContent() -> 204 
	}
}
 