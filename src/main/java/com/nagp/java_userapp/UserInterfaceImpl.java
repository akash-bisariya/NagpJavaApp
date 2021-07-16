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
			this.users.add(new UserModel(counter.incrementAndGet(), "Carpenter", "For all types of wood work"));
			this.users
					.add(new UserModel(counter.incrementAndGet(), "Electrician", "All types of electrical work"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Salon", "Haircut for men and women"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Cleaning", "House cleaning"));
			this.users.add(new UserModel(counter.incrementAndGet(), "AC Repair", "AC repair and service"));
			this.users.add(new UserModel(counter.incrementAndGet(), "Massage for men", "All types of massages"));
		}
		return this.users;
	}

	
}
