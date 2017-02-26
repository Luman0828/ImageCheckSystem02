package com.imagecheck.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;

public interface HomeworkMapper {
	public Homework_Result findResultById(@Param("resultId")int resultId);
	public Homework_Result findResultByUserId(@Param("userId")String userId,@Param("taskId")int taskId);
	public Homework_Task findTaskById(@Param("taskId")int taskId);
	public List<Homework_Task> findTasks(@Param("start")int start,@Param("offset")int offset);
	public List<Homework_Result> findResultsByTaskId(@Param("taskId")int taskId, @Param("start")int start,@Param("offset")int offset);
	public int findTasksCount();
	public int findResultCountByTaskId(@Param("taskId")int taskId);
	public Integer addTask(@Param("task")Homework_Task task);
	public int updateTask(@Param("task")Homework_Task task);
	public int deleteTask(@Param("taskId")int taskId);
	public Integer addResult(@Param("result")Homework_Result result);
	public int updateResult(@Param("result")Homework_Result result);
	public int deleteResult(@Param("resultId")int resultId);
	public int deleteResults(@Param("taskId")int taskId);
}
