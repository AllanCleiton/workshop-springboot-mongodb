package com.allancleiton.workshopmongo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private LocalDateTime date;
	private String title;
	private String bady;
	private User author;
	
	public Post() {}

	public Post(String id, LocalDateTime date, String title, String bady, User author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.bady = bady;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBady() {
		return bady;
	}

	public void setBady(String bady) {
		this.bady = bady;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
