package com.allancleiton.workshopmongo.dto;

import com.allancleiton.workshopmongo.domain.User;

public record UserDTO(
		String id,
		String name,
		String email) {
	
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getEmail());
	}
	
}
