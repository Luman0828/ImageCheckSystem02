package com.imagecheck.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imagecheck.mapper.HomeworkMapper;
import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.util.Page;

@Service @Transactional
public class TeacherServiceBean extends UserServiceBean{
	@Resource(name="homeworkMapper")
    private HomeworkMapper homeworkMapper;

	public boolean publishTask(Homework_Task task){
		return homeworkMapper.addTask(task);
	}
	public boolean deleteTask(int taskId){
		
		return homeworkMapper.deleteTask(taskId)&&homeworkMapper.deleteResults(taskId);
		
	}
	
	public List<Homework_Result> readResultsByTask(int taskId,Page page){
		return homeworkMapper.findResultsByTaskId(taskId, page.getPage(), page.getPageCount());
	}
}
