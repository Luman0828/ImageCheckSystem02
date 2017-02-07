package com.imagecheck.pojo;

public class Homework_Task {
	private int taskId;
	private String name;
	private String description;
	private String srcPath;
	private String functionName;
	
	public Homework_Task() {
		super();
	}
	public Homework_Task(int id, String name, String description, String srcPath, String functionName) {
		super();
		this.taskId = id;
		this.name = name;
		this.description = description;
		this.srcPath = srcPath;
		this.functionName = functionName;
	}
	public int getId() {
		return taskId;
	}
	public void setId(int id) {
		this.taskId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
