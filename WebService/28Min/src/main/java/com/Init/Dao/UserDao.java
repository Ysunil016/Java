package com.Init.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Init.Bean.User;

@Component
public class UserDao {

	private static List<User> usersList = new ArrayList<>();
	private static int userCount = 4;

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
		user.setId(usersList.size() + 1);
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

	public User deleteById(int id) {
		Iterator<User> it = usersList.listIterator();
		while (it.hasNext()) {
			User curUser = it.next();
			if (curUser.getId() == id) {
				it.remove();
				return curUser;
			}
		}
		return null;
	}
}
