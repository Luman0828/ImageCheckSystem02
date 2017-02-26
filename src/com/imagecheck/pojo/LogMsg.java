package com.imagecheck.pojo;

public class LogMsg {
	private String logMsg;
	private User user;
	public LogMsg() {
		super();
	}
	public LogMsg(String logMsg, User user) {
		super();
		this.logMsg = logMsg;
		this.user = user;
	}
	public String getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
