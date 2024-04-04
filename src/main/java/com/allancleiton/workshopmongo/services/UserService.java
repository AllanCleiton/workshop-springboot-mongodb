package com.allancleiton.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allancleiton.workshopmongo.domain.User;
import com.allancleiton.workshopmongo.dto.UserDTO;
import com.allancleiton.workshopmongo.repositories.UserRepository;
import com.allancleiton.workshopmongo.services.exceptions.ObjectNotFoundException;
	

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findByID(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
		
	}
	
	public void delete(String id) {
		userRepository.delete(findByID(id));
	}
	
	public User upDate(User obj) {
		User newObj = findByID(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj );
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.id(), objDTO.name(), objDTO.email());
	}
	
	
}
