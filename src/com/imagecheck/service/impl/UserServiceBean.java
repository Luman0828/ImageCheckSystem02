package com.imagecheck.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imagecheck.mapper.HomeworkMapper;
import com.imagecheck.mapper.UserMapper;
import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.pojo.User;

import com.imagecheck.service.UserService;
import com.imagecheck.util.Page;

@Service @Transactional
public class UserServiceBean implements UserService{

    @Resource(name="userMapper")
    private UserMapper userMapper;
    @Resource(name="homeworkMapper")
    private HomeworkMapper homeworkMapper;

	@Override
	public String login(String userId, String password) {
		// TODO Auto-generated method stub
		
		if(userMapper.findById(userId)==null){
			return "notExist";
		}
		else if(userMapper.findByPassword(userId, password)!=null)
			return "success";
		return "passwordWrong";
	}


	@Override
	public List<Homework_Task> readTasks(Page page) {
		// TODO Auto-generated method stub
		return homeworkMapper.findTasks(page.getPage(), page.getPageCount());
		
	}

	@Override
	public Homework_Task readTask(int taskId) {
		// TODO Auto-generated method stub
		return homeworkMapper.findTaskById(taskId);
	}


	@Override
	public boolean uploadResult(Homework_Result result) {
		// TODO Auto-generated method stub
		return homeworkMapper.addResult(result);
	}





	@Override
	public Homework_Result readOwnResult(int userId, int taskId) {
		// TODO Auto-generated method stub
		return homeworkMapper.findResultByUserId(userId, taskId);
	}


	@Override
	public boolean changeData(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

    
}
