package com.imagecheck.pojo;

public class Homework_Task {
	private int taskId;
	private String title;
	private String description;
	private String srcPath;
	private String functionName;
	
	public Homework_Task() {
		super();
	}
	public Homework_Task(int taskId, String title, String description, String srcPath, String functionName) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.srcPath = srcPath;
		this.functionName = functionName;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	
	
}
