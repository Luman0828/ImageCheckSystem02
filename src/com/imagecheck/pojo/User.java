package com.imagecheck.pojo;

public class User {
	private String userId;
	private String userName;
	private String password;
	private int identity;
	private String classId;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classid) {
		this.classId = classid;
	}
	public User() {
		super();
	}
	public User(String userId, String userName, String password, int identity,String classId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.identity = identity;
		this.classId=classId;
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
