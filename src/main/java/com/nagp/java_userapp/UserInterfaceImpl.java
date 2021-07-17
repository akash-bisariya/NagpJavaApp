package com.nagp.java_userapp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class UserInterfaceImpl implements UserInterface {
	
	List<UserModel> users = new ArrayList<UserModel>();
	private final AtomicLong counter = new AtomicLong(2000);

	@Override
	public UserModel addUser(UserModel user) {
		UserModel userModel = new UserModel(counter.incrementAndGet(), user.getUserName(), user.getUserCity());
		this.users.add(userModel);
		return userModel;
		
	}

	@Override
	public List<UserModel> getAllUsers() {
		if (this.users.isEmpty()) {
			this.users.add(new UserModel(counter.incrementAndGet(), "Akash Bisariya", "Bareilly"));
			this.users
					.add(new UserModel(counter.incrementAndGet(), "Anuj Kumar", "Delhi"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Santosh Khanna", "Hisar"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Sooraj Rathi", "Jaipur"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Pankaj Kumar", "Delhi"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Sandhya Kumari", "Kolkata"));
		}
		return this.users;
	}

	
}
