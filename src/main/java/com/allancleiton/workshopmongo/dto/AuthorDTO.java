package com.allancleiton.workshopmongo.dto;

import com.allancleiton.workshopmongo.domain.User;

public record AuthorDTO (
		String id, 
		String name
){
	public AuthorDTO(User obj) {
		this(obj.getId(), obj.getName());
	}
}
