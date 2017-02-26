package com.imagecheck.pojo;

public class Homework_Result {
	private int resultId;
	private int taskId;
	private String userId;
	private String description;
	private String resultPath;
	
	public Homework_Result() {
		super();
	}

	public Homework_Result(int resultId, int taskId, String userId, String description, String resultPath) {
		super();
		this.resultId = resultId;
		this.taskId = taskId;
		this.userId = userId;
		this.description = description;
		this.resultPath = resultPath;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}
	
	
	
	
}
