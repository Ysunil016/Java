package com.Init.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("UserBeanFilterDynamic") // Dynamic Filter

//@JsonIgnoreProperties(value = {"username"}) // Ignoring set of Field whenever Response is Generated for this Bean
public class UserFilter {
	private String username;

//	@JsonIgnore // Ignoring this Field whenever Response is Generated for this Bean
	private String password;
	private int age;

	public UserFilter(String username, String password, int age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
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
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserFilter [username=" + username + ", password=" + password + ", age=" + age + "]";
	}

}
