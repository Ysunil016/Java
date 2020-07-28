package com.Init.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Init.Bean.User;

@Component
public class UserDao {

	private static List<User> usersList = new ArrayList<>();
	private static int userCount = 3;

	static {
		usersList.add(new User(1, "Sunil", new Date()));
		usersList.add(new User(2, "Nirmala", new Date()));
		usersList.add(new User(3, "Sanjay", new Date()));
		usersList.add(new User(4, "Priyanka", new Date()));
	}

	public List<User> findAll() {
		return usersList;
	}

	public User save(User user) {
		if (user.getId() != null) {
			user.setId(++userCount);
		}
		usersList.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : usersList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
