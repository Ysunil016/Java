package com.Init.Bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	@Size(min = 6, max = 50)
	private String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Post() {
	}

	public Post(Integer id, String description, User user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
