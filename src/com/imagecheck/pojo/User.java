package com.imagecheck.pojo;

public class User {
	private String userId;
	private String userName;
	private String password;
	private int identity;
	

	public User() {
		super();
	}
	public User(String userId, String userName, String password, int identity) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.identity = identity;
	
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userid) {
		this.userId = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
