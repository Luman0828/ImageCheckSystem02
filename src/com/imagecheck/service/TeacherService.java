package com.imagecheck.service;

import java.util.List;

import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.util.Page;

public interface TeacherService extends UserService {
	public boolean publishTask(Homework_Task task);
	public boolean deleteTask(int taskId);
	public boolean updateTask(Homework_Task task);
	public List<Homework_Result> readResultsByTask(int taskId,Page page);
	public int findResultCountByTaskId(int taskId);
	public Homework_Result readResult(int resultId);
	
}
