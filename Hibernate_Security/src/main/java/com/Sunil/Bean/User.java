package com.Sunil.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user_login", catalog = "JPA_HIBERNATE")
public class User {

	@Id
	@Column(name = "username", length = 25)
	private String username;
	@Column(name = "password", length = 255)
	private String password;
	@Column(name = "role")
	private String role;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		// Encoding using BcryptMechanism
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = "ROLE_" + role;
	}

}
