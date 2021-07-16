package com.nagp.java_userapp;

public class UserModel {
	Long userId;
	String userName;
	String userCity;
	
	public UserModel(Long userId, String userName, String userCity) {
		super();
		this.userCity = userCity;
		this.userName = userName;
		this.userCity = userCity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setuserId(String userName) {
		this.userName = userName;
	}
	
	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

}
