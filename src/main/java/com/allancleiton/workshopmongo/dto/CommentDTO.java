package com.allancleiton.workshopmongo.dto;

import java.time.LocalDate;

public record CommentDTO(
	String text,
	LocalDate date,
	AuthorDTO author) {

}
