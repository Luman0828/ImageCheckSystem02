package com.imagecheck.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imagecheck.mapper.HomeworkMapper;
import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.service.TeacherService;
import com.imagecheck.util.Page;

@Service @Transactional
public class TeacherServiceBean extends UserServiceBean implements TeacherService{
	@Resource(name="homeworkMapper")
    private HomeworkMapper homeworkMapper;

	public boolean publishTask(Homework_Task task){
		return homeworkMapper.addTask(task)!=null;
	}
	
	public boolean deleteTask(int taskId){
		
		return homeworkMapper.deleteTask(taskId)>0&&homeworkMapper.deleteResults(taskId)>0;
		
	}
	
	public List<Homework_Result> readResultsByTask(int taskId,Page page){
		return homeworkMapper.findResultsByTaskId(taskId, page.getCurrentPage(), page.getEveryPage());
	}
	public int findResultCountByTaskId(int taskId){
		return homeworkMapper.findResultCountByTaskId(taskId);
	}
	public Homework_Result readResult(int resultId){
		return homeworkMapper.findResultById(resultId);
	}

	@Override
	public boolean updateTask(Homework_Task task) {
		// TODO Auto-generated method stub
		return homeworkMapper.updateTask(task)>0?true:false;
	}
}
