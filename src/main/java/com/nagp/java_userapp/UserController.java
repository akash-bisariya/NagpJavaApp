package com.nagp.java_userapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserInterfaceImpl userInterfaceImpl;
	
	@PostMapping("/adduser")
	UserModel addProvider(@RequestBody UserModel user) {
		return userInterfaceImpl.addUser(user);
	}

	@GetMapping("/getallusers")
	List<UserModel> getAllProviders() {
		return userInterfaceImpl.getAllUsers();

	}
}
